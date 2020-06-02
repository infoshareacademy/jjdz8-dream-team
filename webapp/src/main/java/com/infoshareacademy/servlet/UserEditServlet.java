package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.security.PasswordResolver;
import com.infoshareacademy.service.EditService;
import com.infoshareacademy.service.Service;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.infoshareacademy.servlet.HelperForServlets.*;
import static com.infoshareacademy.servlet.HelperForServlets.isIncorrectCorrectParameter;

public abstract class UserEditServlet extends HttpServlet {

    @Inject
    private TemplateProvider provider;

    public static final String EMPTY_NICKNAME = "emptyNickname";

    public static final String EMPTY_EMAIL = "emptyEmail";

    public static final String WRONG_PASSWORD_FORMAT = "wrongPasswordFormat";

    public static final String WRONG_PASSWORD = "wrongPassword";

    public static final String LOGIN_ERROR = "loginError";

    private String redirectAfterInCorrectForm;

    private String redirectAfterCorrectForm;

    private String templateFile;

    private String sessionAttribute;

    protected void doGetMethod(HttpServletRequest req, HttpServletResponse resp, Service userService) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), templateFile);
        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute(sessionAttribute) == null) {
            dataModel.put("message", getAttributeValue(session, LOGIN_ERROR));
        }
        Optional<User> user = findCorrectUser(session,sessionAttribute,userService);
        user.ifPresent(value -> dataModel.put("user", value));

        putCorrectDataToDataModel("nickName", getAttributeValue(session, "nickName"), dataModel);
        putCorrectDataToDataModel("email", getAttributeValue(session, "email"), dataModel);
        putCorrectDataToDataModel(EMPTY_NICKNAME, getAttributeValue(session, EMPTY_NICKNAME), dataModel);
        putCorrectDataToDataModel(EMPTY_EMAIL, getAttributeValue(session, EMPTY_EMAIL), dataModel);
        putCorrectDataToDataModel(WRONG_PASSWORD, getAttributeValue(session, WRONG_PASSWORD), dataModel);
        putCorrectDataToDataModel(WRONG_PASSWORD_FORMAT, getAttributeValue(session, WRONG_PASSWORD_FORMAT), dataModel);

        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        invalidateAttributes(session, EMPTY_NICKNAME, EMPTY_EMAIL, WRONG_PASSWORD_FORMAT, WRONG_PASSWORD);
    }


    protected void doPostMethod(HttpServletRequest req, HttpServletResponse resp, Service userService, EditService editService) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession(false);

        if (!isValidSession(session, sessionAttribute)) {
            session.setAttribute(LOGIN_ERROR, "you have to login first");
            return;
        }

        Optional<User> user = findCorrectUser(req.getSession(), sessionAttribute, userService);
        if (user.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Something goes wrong");
            return;
        }
        processPostRequest(req, user.get(), editService, userService);
        if (session.getAttribute(EMPTY_NICKNAME) != null || session.getAttribute(EMPTY_EMAIL) != null
                || session.getAttribute(WRONG_PASSWORD) != null || session.getAttribute(WRONG_PASSWORD_FORMAT) != null) {
            resp.sendRedirect(redirectAfterInCorrectForm);
            return;
        }
        resp.sendRedirect(redirectAfterCorrectForm);
    }

    private void processPostRequest(HttpServletRequest req, User user, EditService userEditService, Service userService) throws ServletException, IOException {
        String nickName = req.getParameter("nickName");
        String email = req.getParameter("email");
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        String repeatedPassword = req.getParameter("repeatedPassword");

        HttpSession session = req.getSession(false);

        if (isIncorrectCorrectParameter(nickName)) {
            session.setAttribute(EMPTY_NICKNAME, "nickName cannot be empty");
            return;
        } else session.setAttribute("nickName", nickName);

        if (isIncorrectCorrectParameter(email)) {
            session.setAttribute(EMPTY_EMAIL, "email cannot be empty");
            return;
        }else session.setAttribute("email", email);

        if (isIncorrectCorrectParameter(oldPassword) || !userService.isCorrectPassword(user, oldPassword)) {
            session.setAttribute(WRONG_PASSWORD, "wrong password");
            return;
        } else if (isIncorrectCorrectParameter(newPassword)){
            userEditService.editNickname(user, nickName);
            userEditService.editEmail(user, email);
        }
        if (isIncorrectCorrectParameter(newPassword)) return;

        if (!isIncorrectCorrectParameter(newPassword) && PasswordResolver.isCorrectPasswordFormat(newPassword)
                && !isIncorrectCorrectParameter(repeatedPassword) && newPassword.equals(repeatedPassword)) {
            userEditService.editNickname(user, nickName);
            userEditService.editEmail(user, email);
            userEditService.editPassword(user, PasswordResolver.passwordHashing(newPassword));
        } else {
            session.setAttribute(WRONG_PASSWORD_FORMAT, "wrong password format");
        }
    }

    private Optional<User> findCorrectUser(HttpSession session, String attribute, Service userService) {
        UUID id = (UUID) session.getAttribute(attribute);
        return userService.findById(id);
    }

    public void setRedirectAfterInCorrectForm(String redirectAfterInCorrectForm) {
        this.redirectAfterInCorrectForm = redirectAfterInCorrectForm;
    }

    public void setRedirectAfterCorrectForm(String redirectAfterCorrectForm) {
        this.redirectAfterCorrectForm = redirectAfterCorrectForm;
    }

    public void setTemplateFile(String templateFile) {
        this.templateFile = templateFile;
    }

    public void setSessionAttribute(String sessionAttribute) {
        this.sessionAttribute = sessionAttribute;
    }
}

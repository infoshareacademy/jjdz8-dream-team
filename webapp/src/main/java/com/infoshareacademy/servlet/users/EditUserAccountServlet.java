package com.infoshareacademy.servlet.users;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.security.PasswordResolver;
import com.infoshareacademy.service.EditService;
import com.infoshareacademy.service.Service;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang.StringUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
import static com.infoshareacademy.servlet.users.UserLoginServlet.ATTRIBUTE_NAME;

@WebServlet("/edit-user-account")
public class EditUserAccountServlet extends HttpServlet {

    @Inject
    private TemplateProvider provider;

    @Inject
    private Service service;

    @Inject
    private EditService editService;

    public static final String EMPTY_NICKNAME = "emptyNickname";

    public static final String EMPTY_EMAIL = "emptyEmail";

    public static final String WRONG_PASSWORD_FORMAT = "wrongPasswordFormat";

    public static final String WRONG_PASSWORD = "wrongPassword";

    public static final String LOGIN_ERROR = "loginError";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), "user-account-data-after-edit.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession(false);
        if (!isValidSession(session, ATTRIBUTE_NAME)) {
            session.setAttribute(LOGIN_ERROR, "you have to login first");
            dataModel.put("message", ERROR_MESSAGE);
        } else {

            Optional<User> user = service.findById((UUID) session.getAttribute(ATTRIBUTE_NAME));
            user.ifPresentOrElse(value -> dataModel.put("user", value),
                    () -> {
                        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    });

            putCorrectDataToDataModel("nickName", getAttributeValue(session, "nickName"), dataModel);
            putCorrectDataToDataModel("email", getAttributeValue(session, "email"), dataModel);
            putCorrectDataToDataModel("nickNameExist", getAttributeValue(session,"nickNameExist"), dataModel);
            putCorrectDataToDataModel("emailExist", getAttributeValue(session,"emailExist"), dataModel);
            putCorrectDataToDataModel(EMPTY_NICKNAME, getAttributeValue(session, EMPTY_NICKNAME), dataModel);
            putCorrectDataToDataModel(EMPTY_EMAIL, getAttributeValue(session, EMPTY_EMAIL), dataModel);
            putCorrectDataToDataModel(WRONG_PASSWORD, getAttributeValue(session, WRONG_PASSWORD), dataModel);
            putCorrectDataToDataModel(WRONG_PASSWORD_FORMAT, getAttributeValue(session, WRONG_PASSWORD_FORMAT), dataModel);
        }
        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        invalidateAttributes(session, EMPTY_NICKNAME, EMPTY_EMAIL, WRONG_PASSWORD_FORMAT, WRONG_PASSWORD,"emailExist","nickNameExist");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession(false);
        if (!isValidSession(session, ATTRIBUTE_NAME)) {
            session.setAttribute(LOGIN_ERROR, "you have to login first");
            return;
        }

        Optional<User> user = service.findById((UUID) session.getAttribute(ATTRIBUTE_NAME));
        if (user.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Something goes wrong");
            return;
        }
        processPostRequest(req, user.get(), editService, service);

        if (session.getAttribute(EMPTY_NICKNAME) != null  || session.getAttribute(EMPTY_EMAIL) != null
                || session.getAttribute(WRONG_PASSWORD) != null || session.getAttribute(WRONG_PASSWORD_FORMAT) != null
        || session.getAttribute("nickNameExist") !=null || session.getAttribute("emailExist")!=null) {
            resp.sendRedirect("/edit-user-account");
            return;
        }
        resp.sendRedirect("/account-info");
    }


    private void processPostRequest(HttpServletRequest req, User user, EditService userEditService, Service userService) throws ServletException, IOException {
        String nickName = req.getParameter("nickName");
        String email = req.getParameter("email");
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        String repeatedPassword = req.getParameter("repeatedPassword");

        HttpSession session = req.getSession(false);
        UUID id = (UUID) session.getAttribute(ATTRIBUTE_NAME);

        if (StringUtils.isEmpty(nickName)) {
            session.setAttribute(EMPTY_NICKNAME, "nickName cannot be empty");
        }
        if (service.nicknameAlreadyExist(nickName,id)){
            session.setAttribute("nickNameExist", nickName);
        }
        else session.setAttribute("nickName", nickName);

        if (StringUtils.isEmpty(email)) {
            session.setAttribute(EMPTY_EMAIL, "email cannot be empty");
        }
        if (service.emailAlreadyExist(email,id)){
            session.setAttribute("emailExist",email);
        }
        else session.setAttribute("email", email);

        if (StringUtils.isEmpty(oldPassword) || !userService.isCorrectPassword(user, oldPassword)) {
            session.setAttribute(WRONG_PASSWORD, "wrong password");
            return;
        } else if (StringUtils.isEmpty(newPassword) && !email.isEmpty() && !nickName.isEmpty()
        && !service.nicknameAlreadyExist(nickName,id) && !service.emailAlreadyExist(email,id)) {
            userEditService.editNickname(user, nickName);
            userEditService.editEmail(user, email);
            return;
        }
        if (StringUtils.isEmpty(newPassword)) {return;}
        if (PasswordResolver.isCorrectPasswordFormat(newPassword) && newPassword.equals(repeatedPassword)){
            userEditService.editNickname(user, nickName);
            userEditService.editEmail(user, email);
            userEditService.editPassword(user, PasswordResolver.passwordHashing(newPassword));
        } else {
            session.setAttribute(WRONG_PASSWORD_FORMAT, "wrong password format");
        }
    }

}

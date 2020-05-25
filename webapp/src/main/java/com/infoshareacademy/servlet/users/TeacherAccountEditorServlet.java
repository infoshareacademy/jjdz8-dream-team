package com.infoshareacademy.servlet.users;


import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.UserEditService;
import com.infoshareacademy.service.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/edit-teacher-account")
public class TeacherAccountEditorServlet extends HttpServlet {

    @Inject
    private TemplateProvider provider;

    @Inject
    private UserEditService userEditService;

    @Inject
    private UserService userService;

    public static final String EMPTY_NICKNAME = "emptyNickname";

    public static final String EMPTY_EMAIL = "emptyEmail";

    public static final String EMPTY_PASSWORD = "emptyPassword";
    
    public static final String LOGIN_ERROR = "loginError";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), "teacher-account-data-after-edit.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession(false);
        if (session.getAttribute("id") == null) {
            dataModel.put("message", getAttributeValue(session, LOGIN_ERROR));
        }
        Optional<User> user = findCorrectUser(session, "id");
        user.ifPresent(value -> dataModel.put("user", value));

        putCorrectDataToDataModel(EMPTY_NICKNAME, getAttributeValue(session, EMPTY_NICKNAME), dataModel);
        putCorrectDataToDataModel(EMPTY_EMAIL, getAttributeValue(session, EMPTY_EMAIL), dataModel);
        putCorrectDataToDataModel(EMPTY_PASSWORD, getAttributeValue(session, EMPTY_PASSWORD), dataModel);

        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        invalidateAttributes(session, EMPTY_NICKNAME,EMPTY_EMAIL,EMPTY_PASSWORD);
    }

    private void invalidateAttributes(HttpSession session, String ... attributeNames) {
        for (String attributeName : attributeNames) {
            if (session.getAttribute(attributeName) != null) {
                session.removeAttribute(attributeName);
            }
        }

    }
    private void putCorrectDataToDataModel(String modelKey, String modelValue, Map<String, Object> dataModel) {
        if (!modelValue.isEmpty()) {
            dataModel.put(modelKey, modelValue);
        }
    }

    private String getAttributeValue(HttpSession session, String attributeName) {
        String attribute="";
        if (session.getAttribute(attributeName) != null){
            attribute = (String) session.getAttribute(attributeName);
        }
        return attribute;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession(false);

        if (!isValidDoPostSession(session)) {
            session.setAttribute(LOGIN_ERROR,"you have to login first");
            return;
        }

        Optional<User> user = findCorrectUser(req.getSession(), "id");
        if (user.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Something goes wrong");
            return;
        }
        processPostRequest(req, user.get());
        if (session.getAttribute(EMPTY_NICKNAME)!=null || session.getAttribute(EMPTY_EMAIL) !=null
                || session.getAttribute(EMPTY_PASSWORD) !=null){
            resp.sendRedirect("/edit-teacher-account");
            return;
        }
        resp.sendRedirect("/teacher-account-information");
    }

    private void processPostRequest(HttpServletRequest req, User user)  throws ServletException, IOException {
        String nickName = req.getParameter("nickName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession session =req.getSession(false);

        if (isIncorrectCorrectParameter(nickName)) {
            session.setAttribute(EMPTY_NICKNAME,"nickName cannot be empty");
        } else {
            userEditService.editNickname(user, nickName);
        }

        if (isIncorrectCorrectParameter(email)) {
            session.setAttribute(EMPTY_EMAIL,"email cannot be empty");
        } else {
            userEditService.editEmail(user, email);
        }

        if (isIncorrectCorrectParameter(password)) {
            session.setAttribute(EMPTY_PASSWORD,"password cannot be empty");

        } else {
            userEditService.editPassword(user, password);
        }
    }

    private boolean isIncorrectCorrectParameter(String parameter) {
        return (parameter == null || parameter.isEmpty());
    }

    private Optional<User> findCorrectUser(HttpSession session, String attribute) {
        UUID id = (UUID) session.getAttribute(attribute);
        return userService.findById(id);
    }

    private boolean isValidDoPostSession(HttpSession session) {
        return session.getAttribute("id") != null;
    }
}

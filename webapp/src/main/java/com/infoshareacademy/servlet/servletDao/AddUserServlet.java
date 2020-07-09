package com.infoshareacademy.servlet.servletDao;

import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.servisDao.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang.StringUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static com.infoshareacademy.servlet.HelperForServlets.*;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {

    @Inject
    private TemplateProvider provider;

    @Inject
    private UserService userService;

    public static final String EMPTY_NICKNAME = "emptyNickName";

    public static final String EMPTY_EMAIL = "emptyEmail";

    public static final String INCORRECT_PASSWORD = "incorrectPassword";

    public static final String EMAIL_EXIST = "emailExist";

    public static final String NICKNAME_EXIST = "nickNameExist";

    public static final String INCORRECT_FORM = "incorrectForm";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        HttpSession session = req.getSession(false);

        Template template = provider.getTemplate(getServletContext(), "add-user.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        if (session.getAttribute(INCORRECT_FORM) != null) {
            putCorrectDataToDataModel(EMPTY_NICKNAME, getAttributeValue(session, EMPTY_NICKNAME), dataModel);
            putCorrectDataToDataModel("nickName", getAttributeValue(session, "nickName"), dataModel);
            putCorrectDataToDataModel(EMPTY_EMAIL, getAttributeValue(session, EMPTY_EMAIL), dataModel);
            putCorrectDataToDataModel("email", getAttributeValue(session, "email"), dataModel);
            putCorrectDataToDataModel(INCORRECT_PASSWORD, getAttributeValue(session, INCORRECT_PASSWORD), dataModel);
            putCorrectDataToDataModel(EMAIL_EXIST, getAttributeValue(session, EMAIL_EXIST), dataModel);
            putCorrectDataToDataModel(NICKNAME_EXIST, getAttributeValue(session, NICKNAME_EXIST), dataModel);
            putCorrectDataToDataModel(INCORRECT_FORM, getAttributeValue(session, INCORRECT_FORM), dataModel);

            invalidateAttributes(session,
                    EMPTY_NICKNAME, EMPTY_EMAIL, INCORRECT_PASSWORD, EMAIL_EXIST, NICKNAME_EXIST,
                    "nickName", "email");
            req.getSession().removeAttribute(INCORRECT_FORM);

        }
        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession(true);

        String nickName = req.getParameter("nickName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String repeatedPassword = req.getParameter("repeatedPassword");
        String role = req.getParameter("role");

        if (StringUtils.isEmpty(nickName)) {
            session.setAttribute(EMPTY_NICKNAME, "Nickname cannot be empty");
        } else {
            System.out.println("nickname istnieje "+userService.nickNameAlreadyExist(nickName,0L));
            if (userService.nickNameAlreadyExist(nickName, 0L)) {
                session.setAttribute(NICKNAME_EXIST, "true");
            } else session.setAttribute("nickName", nickName);
        }
        if (StringUtils.isEmpty(email)) {
            session.setAttribute(EMPTY_EMAIL, "Email cannot be empty");
        } else {
            System.out.println("email istnieje "+userService.emailAlreadyExist(email,0L));
            if (userService.emailAlreadyExist(email, 0L)) {
                session.setAttribute(EMAIL_EXIST, "true");
            } else session.setAttribute("email", email);
        }
        if (StringUtils.isEmpty(password) || StringUtils.isEmpty(repeatedPassword) || !password.equals(repeatedPassword)) {
            session.setAttribute(INCORRECT_PASSWORD, "Password cannot be empty");
        } else {
            session.setAttribute("password", password);
        }


        if (session.getAttribute(EMPTY_NICKNAME) != null || session.getAttribute(INCORRECT_PASSWORD) != null
                || session.getAttribute(EMPTY_EMAIL) != null || session.getAttribute(EMAIL_EXIST) != null || session.getAttribute(NICKNAME_EXIST) != null) {
            session.setAttribute(INCORRECT_FORM, INCORRECT_FORM);
            resp.sendRedirect("/add-user");
            return;
        }

        userService.createUser(nickName, email, password, role);
        resp.setStatus(HttpServletResponse.SC_CREATED);

        session.setAttribute("login", nickName);
        session.setMaxInactiveInterval(900);
        resp.sendRedirect("/account-info");
    }


}

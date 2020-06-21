package com.infoshareacademy.servlet.users;

import com.infoshareacademy.domain.Role;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.RoleService;
import com.infoshareacademy.service.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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

import static com.infoshareacademy.servlet.HelperForServlets.*;
import static com.infoshareacademy.validation.ParameterValidator.isIncorrectCorrectParameter;

@WebServlet("/add-user")
public class AddUserAccountServlet extends HttpServlet {

    @Inject
    TemplateProvider provider;

    @Inject
    UserService userService;

    @Inject
    RoleService roleService;

    public static final String EMPTY_NICKNAME = "emptyNickName";

    public static final String EMPTY_EMAIL = "emptyEmail";

    public static final String EMPTY_PASSWORD = "emptyPassword";

    public static final String EMPTY_WHOYOUARE = "emptyWhoYouAre";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        HttpSession session = req.getSession(true);

        String nickName = req.getParameter("nickName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String whoIAm = req.getParameter("whoIAm");

        if (isIncorrectCorrectParameter(nickName)) {
            session.setAttribute(EMPTY_NICKNAME, "Nickname cannot be empty");
        } else {
            session.setAttribute("nickName", nickName);
        }
        if (isIncorrectCorrectParameter(email)) {
            session.setAttribute(EMPTY_EMAIL, "Email cannot be empty");
        } else {
            session.setAttribute("email", email);
        }
        if (isIncorrectCorrectParameter(password)) {
            session.setAttribute(EMPTY_PASSWORD, "Password cannot be empty");
        } else {
            session.setAttribute("password", password);
        }
        if (isIncorrectCorrectParameter(whoIAm)) {
            session.setAttribute(EMPTY_WHOYOUARE, "Pick who you are");
        } else {
            session.setAttribute("whoIAm", whoIAm);
        }

        if (session.getAttribute(EMPTY_NICKNAME) != null || session.getAttribute(EMPTY_PASSWORD) != null
                || session.getAttribute(EMPTY_EMAIL) != null || session.getAttribute(EMPTY_WHOYOUARE) != null) {
            resp.sendRedirect("/add-user");
            return;
        }

        Role role = roleService.roleFromString(whoIAm);

        User user = userService.createUser(nickName, email, password, role);
        userService.addUser(user);
        resp.sendRedirect("/account-info");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), "user-after-added-incorrect-data.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession(true);

            putCorrectDataToDataModel(EMPTY_NICKNAME, getAttributeValue(session, EMPTY_NICKNAME), dataModel);
            putCorrectDataToDataModel("nickName", getAttributeValue(session, "nickName"), dataModel);
            putCorrectDataToDataModel(EMPTY_EMAIL, getAttributeValue(session, EMPTY_EMAIL), dataModel);
            putCorrectDataToDataModel("email", getAttributeValue(session, "email"), dataModel);
            putCorrectDataToDataModel(EMPTY_PASSWORD, getAttributeValue(session, EMPTY_PASSWORD), dataModel);
            putCorrectDataToDataModel("password", getAttributeValue(session, "password"), dataModel);
            putCorrectDataToDataModel(EMPTY_WHOYOUARE, getAttributeValue(session, EMPTY_WHOYOUARE), dataModel);
            putCorrectDataToDataModel("whoIAm", getAttributeValue(session, "whoIAm"), dataModel);

        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        invalidateAttributes(session,
                EMPTY_NICKNAME, EMPTY_EMAIL, EMPTY_PASSWORD, EMPTY_WHOYOUARE,
                "nickName", "email", "password", "whoIAm");
    }
}

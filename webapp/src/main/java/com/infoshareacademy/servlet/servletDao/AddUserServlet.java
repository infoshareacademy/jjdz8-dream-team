package com.infoshareacademy.servlet.servletDao;

import com.infoshareacademy.domain.Role;
import com.infoshareacademy.entity.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.servisDao.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import static com.infoshareacademy.servlet.HelperForServlets.*;
import static com.infoshareacademy.validation.ParameterValidator.isIncorrectCorrectParameter;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {

    @Inject
    private TemplateProvider provider;

    @Inject
    private UserService userService;

    public static final String EMPTY_NICKNAME = "emptyNickName";

    public static final String EMPTY_EMAIL = "emptyEmail";

    public static final String EMPTY_PASSWORD = "emptyPassword";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        HttpSession session = req.getSession(false);

        Template template = provider.getTemplate(getServletContext(), "add-user.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        if (session.getAttribute("incorrectForm") != null) {
            putCorrectDataToDataModel(EMPTY_NICKNAME, getAttributeValue(session, EMPTY_NICKNAME), dataModel);
            putCorrectDataToDataModel("nickName", getAttributeValue(session, "nickName"), dataModel);
            putCorrectDataToDataModel(EMPTY_EMAIL, getAttributeValue(session, EMPTY_EMAIL), dataModel);
            putCorrectDataToDataModel("email", getAttributeValue(session, "email"), dataModel);
            putCorrectDataToDataModel(EMPTY_PASSWORD, getAttributeValue(session, EMPTY_PASSWORD), dataModel);
            putCorrectDataToDataModel("incorrectForm","coś poszło nie tak", dataModel);

            invalidateAttributes(session,
                    EMPTY_NICKNAME, EMPTY_EMAIL, EMPTY_PASSWORD,
                    "nickName", "email");
            req.getSession().removeAttribute("incorrectForm");

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
            PrintWriter printWriter = resp.getWriter();

            HttpSession session = req.getSession(true);

            String nickName = req.getParameter("nickName");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String repeatedPassword = req.getParameter("repeatedPassword");
            String role = req.getParameter("role");

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
            if (isIncorrectCorrectParameter(password) || isIncorrectCorrectParameter(repeatedPassword) || !password.equals(repeatedPassword)) {
                session.setAttribute(EMPTY_PASSWORD, "Password cannot be empty");
            } else {
                session.setAttribute("password", password);
            }


            if (session.getAttribute(EMPTY_NICKNAME) != null || session.getAttribute(EMPTY_PASSWORD) != null
                    || session.getAttribute(EMPTY_EMAIL) != null) {
                session.setAttribute("incorrectForm", "incorrectForm");
                resp.sendRedirect("/add-user");
                return;
            }

            userService.createUser(nickName,email,password,role);
            resp.setStatus(HttpServletResponse.SC_CREATED);

            Cookie cookie = new Cookie("nickname", nickName);
            resp.addCookie(cookie);
     /*       session.setAttribute("user", nickName );*/
            resp.sendRedirect("/account-info");
        }


}

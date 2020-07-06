package com.infoshareacademy.servlet.users;

import com.infoshareacademy.domain.ROLE;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.EditService;
import com.infoshareacademy.service.Service;
import com.infoshareacademy.validation.UserValidator;
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
import java.util.Optional;
import java.util.UUID;

import static com.infoshareacademy.servlet.HelperForServlets.ERROR_MESSAGE;
import static com.infoshareacademy.servlet.HelperForServlets.isValidSession;
import static com.infoshareacademy.servlet.users.UserLoginServlet.SESSION_MARK;

@WebServlet("/edit-password")
public class EditPasswordServlet extends HttpServlet {

    @Inject
    TemplateProvider provider;

    @Inject
    private Service service;

    @Inject
    private EditService editService;

   /* @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        HttpSession session = req.getSession(false);

        Template template = provider.getTemplate(getServletContext(), "edit-password-page.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        if (!isValidSession(session, SESSION_MARK)) {
            dataModel.put("message", ERROR_MESSAGE);
        } else {
            if (session.getAttribute("inCorrectPassword") != null) {
                dataModel.put("inCorrectPassword", "zmiana hasła nie powiodła się");
            }
            if (session.getAttribute("correctPassword") != null) {
                dataModel.put("correctPassword", "zmiana hasła powiodła się");
            }
            Optional<User> user = service.findById((UUID) session.getAttribute(SESSION_MARK));
            user.ifPresentOrElse(value -> {
                        dataModel.put("user", value);
                        if (value.getRole().equals(ROLE.TEACHER)) dataModel.put("roleTeacher", "TEACHER");
                    },
                    () -> {
                        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    });
            try {
                template.process(dataModel, printWriter);
                resp.setStatus(HttpServletResponse.SC_ACCEPTED);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }


        session.removeAttribute("inCorrectPassword");
        session.removeAttribute("correctPassword");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String newPassword = req.getParameter("newPassword");
        String repeatedPassword = req.getParameter("repeatedPassword");
        String oldPassword = req.getParameter("oldPassword");

        HttpSession session = req.getSession(false);
        if (!isValidSession(session, SESSION_MARK)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Optional<User> user = service.findById((UUID) session.getAttribute(SESSION_MARK));
        if (user.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        boolean isCorrectNewPassword = UserValidator.isCorrectFormatOfNewPassword(newPassword);
        boolean isCorrectRepeatedPassword = isCorrectNewPassword && newPassword.equals(repeatedPassword);
        boolean isCorrectOldPassword = UserValidator.isCorrectPassword(oldPassword, service, user.get());

        if (isCorrectNewPassword && isCorrectRepeatedPassword && isCorrectOldPassword) {
            editService.editPassword(user.get(), newPassword);
            session.setAttribute("correctPassword", "correctPassword");

        } else {
            session.setAttribute("inCorrectPassword", "incorrectPassword");
        }
        resp.sendRedirect("/edit-password");
    }*/
}

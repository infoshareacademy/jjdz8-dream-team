package com.infoshareacademy.servlet.users;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.Service;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static com.infoshareacademy.servlet.HelperForServlets.*;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    @Inject
    private Service service;

    @Inject
    private TemplateProvider provider;

    private static final String SESSION_ATTRIBUTE = "studentID";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), "student-account-information-page-new.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession(false);
        if (!isValidSession(session, SESSION_ATTRIBUTE)) {
            dataModel.put("message", ERROR_MESSAGE);
        }else {
            UUID id = (UUID) session.getAttribute(SESSION_ATTRIBUTE);
            service.findById(id).ifPresentOrElse(user -> dataModel.put("user", user),
                    () -> dataModel.put("message", ERROR_MESSAGE));
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
        String nickName = req.getParameter("nickName");

        if (isIncorrectCorrectParameter(nickName)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "student not exist");
            return;
        }
        Optional<User> user = service.findByNickName(nickName);

        if (user.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        HttpSession session = req.getSession(true);
        session.setAttribute(SESSION_ATTRIBUTE, user.get().getId());
        resp.sendRedirect("/student");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (!isValidSession(session, SESSION_ATTRIBUTE)) {
            resp.getWriter().write(ERROR_MESSAGE);
            return;
        }
        String id = req.getParameter("id");
        if (isIncorrectCorrectParameter(id)) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Optional<User> user = service.findById(UUID.fromString(id));
        if (user.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        service.delete(user.get());
        req.getSession(false).invalidate();
    }
}

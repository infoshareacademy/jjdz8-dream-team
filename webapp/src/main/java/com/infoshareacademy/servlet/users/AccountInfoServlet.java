package com.infoshareacademy.servlet.users;


import com.infoshareacademy.domain.Role;
import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.Service;
import com.infoshareacademy.service.SubjectService;
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
import java.util.*;

import static com.infoshareacademy.servlet.users.UserLoginServlet.ATTRIBUTE_NAME;

@WebServlet("/account-info")
public class AccountInfoServlet extends HttpServlet {

    @Inject
    private SubjectService subjectService;

    @Inject
    private TemplateProvider provider;

    @Inject
    private Service service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), "user-account-information-page-new.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession(false);
        UUID id;
        Optional<User> user;

        if (session == null || session.getAttribute(ATTRIBUTE_NAME) == null) {
            dataModel.put("message", "please login first");
        } else {
            id = (UUID) session.getAttribute(ATTRIBUTE_NAME);
            user = service.findById(id);
            if (user.isEmpty()) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            dataModel.put("user", user.get());
            System.out.println(user.get().getRole());
            if (user.get().getRole().equals(Role.TEACHER)) {
                dataModel.put("roleTeacher", "TEACHER");
                List<Subject> subjects;
                subjects = subjectService.findAllSubjectsForTeacher(user.get().getId());

                if (subjects!= null && subjects.size() > 0) {
                    dataModel.put("subjects", subjects);
                }
            }
        }
        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.Service;
import com.infoshareacademy.service.SubjectService;
import com.infoshareacademy.service.TeacherService;
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

@WebServlet("/teacher-account-information")
public class TeacherAccountInformationServlet extends HttpServlet {

    @Inject
    private SubjectService subjectService;

    @Inject
    private TemplateProvider provider;

    @Inject
    @Named("TeacherService")
    Service service;

    private static final String SESSION_ATTRIBUTE = "teacherID";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), "teacher-account-information-page-new.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession(false);
        UUID id;
        Optional<User> user;

        if (session == null || session.getAttribute(SESSION_ATTRIBUTE) == null) {
            dataModel.put("message", "please login first");
        } else {
            id = (UUID) session.getAttribute(SESSION_ATTRIBUTE);
            user = service.findById(id);
            List<Subject> subjects;
            if (user.isEmpty()) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            subjects = subjectService.findAllSubjectsForTeacher(user.get().getId());
            subjects.forEach(e -> System.out.println(e.getName()));
            dataModel.put("user", user.get());
            if (subjects.size() > 0) {
                dataModel.put("subjects", subjects);
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

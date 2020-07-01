package com.infoshareacademy.servlet.servletDao;


import com.infoshareacademy.domain.ROLE;
import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.Service;
import com.infoshareacademy.service.SubjectService;
import com.infoshareacademy.service.servisDao.UserService;
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

import static com.infoshareacademy.servlet.users.UserLoginServlet.SESSION_MARK;

@WebServlet("/account-info")
public class AccountInfoServlet extends HttpServlet {

    @Inject
    private SubjectService subjectService;

    @Inject
    private TemplateProvider provider;

   @Inject
    UserService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), "user-account-information-page.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute(SESSION_MARK) == null) {
            dataModel.put("message", "please login first");
        } else {
            long id = (Long) session.getAttribute(SESSION_MARK);
            service.findById(id).ifPresentOrElse(u -> {
                dataModel.put("user", u);
                if (u.get().getRole().equals(ROLE.TEACHER)) {
                    dataModel.put("roleTeacher", "TEACHER");
                    Optional<Set<Subject>> subjects;
                    subjects = Optional.of(u.get().getSubjects());
                    subjects.ifPresent(subjectList -> dataModel.put("subjects", subjectList));
                }
            }, () -> {
                try {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}

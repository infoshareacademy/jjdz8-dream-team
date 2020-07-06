package com.infoshareacademy.servlet.subjects;

import com.infoshareacademy.domain.ROLE;
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

import static com.infoshareacademy.servlet.HelperForServlets.*;
import static com.infoshareacademy.servlet.HelperForServlets.isValidSession;
import static com.infoshareacademy.servlet.subjects.EditSubjectServlet.EMPTY_FORM_PARAMETER;
import static com.infoshareacademy.servlet.users.UserLoginServlet.SESSION_MARK;

@WebServlet("/subject")
public class SubjectServlet extends HttpServlet {

    @Inject
    private SubjectService service;

    @Inject
    private TemplateProvider provider;

    @Inject
    private Service userService;


 /*   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String id = req.getParameter("id");

        Template template = provider.getTemplate(getServletContext(), "subject-information-page-new.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        HttpSession session = req.getSession(false);
        if (!isValidSession(session, SESSION_MARK)) {
            dataModel.put("message", ERROR_MESSAGE);
        } else {
            Optional<User> user = userService.findById((UUID) session.getAttribute(SESSION_MARK));
            user.ifPresentOrElse(u -> dataModel.put("user", u),
                    () -> {
                        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    });
            Optional<Subject> subject = service.findById(UUID.fromString(id));
            if (subject.isEmpty()) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            dataModel.put("subject", subject.get());
            dataModel.put("isVideo", String.valueOf(subject.get().isVideo()));
        }
        try {
            template.process(dataModel, out);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("subjectId", UUID.fromString(id));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);
        if (!isValidSession(session, SESSION_MARK)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "please login first");
            return;
        }

        String id = req.getParameter("id");
        if (isIncorrectCorrectParameter(id)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "something goes wrong");
            return;
        }
        processRequest(resp, out, UUID.fromString(id),session);

    }

    public void processRequest(HttpServletResponse resp, PrintWriter out, UUID id, HttpSession session) throws IOException {
        Optional<Subject> subject = service.findById(id);
        if (subject.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Template template = provider.getTemplate(getServletContext(), "subject-information-page-new.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        Optional<User> user = userService.findById((UUID) session.getAttribute(SESSION_MARK));
        user.ifPresentOrElse(value -> {
                    dataModel.put("user", value);
                    if (value.getRole().equals(ROLE.TEACHER)) dataModel.put("roleTeacher", "TEACHER");
                },
                () -> {
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                });

        if (session.getAttribute(EMPTY_FORM_PARAMETER)!= null) {
            dataModel.put(EMPTY_FORM_PARAMETER, EMPTY_FORM_PARAMETER);
        }
        dataModel.put("subject", subject.get());
        if (subject.get().isVideo()) {
            dataModel.put("isVideo", "tak");
        } else dataModel.put("isVideo", "nie");
        try {
            template.process(dataModel, out);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        session.removeAttribute(EMPTY_FORM_PARAMETER);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (!isValidSession(session, SESSION_MARK)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "please login first");
            return;
        }

        String id = req.getParameter("id");
        if (isIncorrectCorrectParameter(id)) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Optional<Subject> subject = service.findById(UUID.fromString(id));
        if (subject.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        service.delete(subject.get());
    }*/
}

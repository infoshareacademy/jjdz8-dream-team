package com.infoshareacademy.servlet.users;

import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.repository.SubjectRepositoryInterface;
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

import static com.infoshareacademy.servlet.HelperForServlets.isValidSession;

@WebServlet("/teacher")
public class TeacherServlet extends HttpServlet {

    @Inject
    TemplateProvider provider;

    @Inject
    @Named("TeacherService")
    private Service service;

    @Inject
    private SubjectRepositoryInterface subjectRepository;

    private static final String SESSION_ATTRIBUTE = "teacherID";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        HttpSession session = req.getSession(false);

        Template template = provider.getTemplate(getServletContext(), "teacher-account-data-form-before-edit-new.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        if (!isValidSession(session, SESSION_ATTRIBUTE)) {
            dataModel.put("message", "please login first");
        } else {
            UUID id = (UUID) session.getAttribute(SESSION_ATTRIBUTE);
            Optional<User> user = service.findById(id);
            List<Subject> subjects;
            if (user.isEmpty()) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            subjects = subjectRepository.findAllSubjectForTeacher(user.get().getId());
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String loginUser = req.getParameter("user");
        String nickName = req.getParameter("nickName");

        if (loginUser.equals("teacher")) {
            if (nickName == null || nickName.isEmpty()) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            Optional<User> user = service.findByNickName(nickName);
            if (user.isEmpty()) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            HttpSession session = req.getSession(true);
            session.setAttribute(SESSION_ATTRIBUTE, user.get().getId());
            resp.sendRedirect("/teacher-account-information");
        } else if (loginUser.equals("student")) {
            req.getRequestDispatcher("/student").forward(req, resp);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        String id = req.getParameter("id");
        if (id == null || id.isEmpty()) {
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

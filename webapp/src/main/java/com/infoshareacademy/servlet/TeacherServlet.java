package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.repository.SubjectRepositoryInterface;
import com.infoshareacademy.service.Service;
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
import java.util.logging.Logger;

import static com.infoshareacademy.servlet.HelperForServlets.ERROR_MESSAGE;
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

    private static final Logger logger = Logger.getLogger(TeacherServlet.class.getName());

    private static final String SESSION_ATTRIBUTE ="teacherID";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        HttpSession session = req.getSession(false);
        String errorMassage;
        if (!isValidSession(session, SESSION_ATTRIBUTE)) {
            errorMassage = "Please login first";
            printWriter.write(errorMassage);
            return;
        }

        Template template = provider.getTemplate(getServletContext(), "teacher-account-data-form.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        if (!isValidSession(session, SESSION_ATTRIBUTE)) {
            dataModel.put("message", ERROR_MESSAGE);
        } else {
            UUID id = (UUID) session.getAttribute("id");
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

        String nickName = req.getParameter("nickName");
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
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.getWriter().write(ERROR_MESSAGE);
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

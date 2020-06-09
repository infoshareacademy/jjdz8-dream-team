package com.infoshareacademy.servlet.users;


import com.infoshareacademy.domain.ROLE;
import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.repository.SubjectRepositoryInterface;
import com.infoshareacademy.service.Service;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang.StringUtils;

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

import static com.infoshareacademy.servlet.HelperForServlets.isValidSession;
import static com.infoshareacademy.servlet.users.UserLoginServlet.ATTRIBUTE_NAME;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Inject
    TemplateProvider provider;

    @Inject
    private Service service;

    @Inject
    private SubjectRepositoryInterface subjectRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        HttpSession session = req.getSession(false);

        Template template = provider.getTemplate(getServletContext(), "user-account-data-form-before-edit.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        if (!isValidSession(session, ATTRIBUTE_NAME)) {
            dataModel.put("message", "please login first");
        } else {
            UUID id = (UUID) session.getAttribute(ATTRIBUTE_NAME);
            Optional<User> user = service.findById(id);

            if (user.isEmpty()) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
            dataModel.put("user", user.get());
            if (user.get().getRole().equals(ROLE.TEACHER)) {
                List<Subject> subjects;
                subjects = subjectRepository.findAllSubjectForTeacher(user.get().getId());

                if (subjects.size() > 0) {
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

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute(ATTRIBUTE_NAME) == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        String id = req.getParameter("id");
        if (StringUtils.isEmpty(id)) {
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

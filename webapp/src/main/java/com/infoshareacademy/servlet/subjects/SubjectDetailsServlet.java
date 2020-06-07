package com.infoshareacademy.servlet.subjects;

import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.Service;
import com.infoshareacademy.service.SubjectService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static com.infoshareacademy.servlet.HelperForServlets.isIncorrectCorrectParameter;

@WebServlet("/subject-details")
public class SubjectDetailsServlet extends HttpServlet {

    @Inject
    private TemplateProvider provider;

    @Inject
    private SubjectService service;

    @Inject
    private Service userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        String id = req.getParameter("id");
        String teacherId = req.getParameter("teacherId");

        if (isIncorrectCorrectParameter(id) && isIncorrectCorrectParameter(teacherId)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Template template = provider.getTemplate(getServletContext(), "subject-details-after-searching.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        if (!isIncorrectCorrectParameter(id)) {
            service.findById(UUID.fromString(id)).ifPresentOrElse(subject -> {
                        dataModel.put("subject", subject);
                        System.out.println(subject.getTeacherId());
                        Optional<User> teacher = userService.findById(subject.getTeacherId());
                        teacher.ifPresent(user -> dataModel.put("user", user));
                        dataModel.put("isVideo", String.valueOf(subject.isVideo()));
                    },
                    () -> dataModel.put("message", "something goes wrong"));
        } else if (!isIncorrectCorrectParameter(teacherId)) {
            List<Subject> subjects = service.findAllSubjectsForTeacher(UUID.fromString(teacherId));
            if (subjects != null && subjects.size() > 0) {
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

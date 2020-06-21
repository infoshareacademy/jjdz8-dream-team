package com.infoshareacademy.servlet.subjects;

import com.infoshareacademy.domain.ROLE;
import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.repository.SubjectRepositoryInterface;
import com.infoshareacademy.service.Service;
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

import static com.infoshareacademy.servlet.HelperForServlets.isValidSession;
import static com.infoshareacademy.servlet.users.UserLoginServlet.SESSION_MARK;

@WebServlet("/show-subjects")
public class ShowSubjectsServlet extends HttpServlet {

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

        Template template = provider.getTemplate(getServletContext(), "show-all-teacher-subjects.ftlh");
        Map<String, Object> dataModel = new HashMap<>();


        if (!isValidSession(session, SESSION_MARK)) {
            dataModel.put("message", "please login first");
        } else {
            Optional<User> user = service.findById((UUID) session.getAttribute(SESSION_MARK));
            user.ifPresentOrElse(u -> {
                        dataModel.put("user", u);
                        if (u.getRole().equals(ROLE.TEACHER)) {
                            dataModel.put("roleTeacher", "TEACHER");
                            List<Subject> subjects;
                            subjects = subjectRepository.findAllSubjectForTeacher(u.getId());

                            if (subjects.size() > 0) {
                                dataModel.put("subjects", subjects);
                            }
                        }
                    },
                    () -> resp.setStatus(HttpServletResponse.SC_BAD_REQUEST));
        }
        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}


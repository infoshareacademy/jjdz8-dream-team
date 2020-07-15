package com.infoshareacademy.servlet.subjects;

import com.infoshareacademy.domain.ROLE;
import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.Service;
import com.infoshareacademy.service.SubjectEditService;
import com.infoshareacademy.service.SubjectService;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.infoshareacademy.servlet.HelperForServlets.*;

@WebServlet("/edit-subject")
public class EditSubjectServlet extends HttpServlet {

    @Inject
    private SubjectEditService editService;

    @Inject
    private SubjectService service;

    @Inject
    private TemplateProvider provider;

    @Inject
    private Service userService;

    public static final String EMPTY_NAME = "emptyName";

    public static final String EMPTY_TOPIC = "emptyTopic";

    public static final String EMPTY_DESCRIPTION = "emptyDescription";
    public static final String EMPTY_FORM_PARAMETER = "emptyForm";

    private static final String SESSION_ATTRIBUTE = "teacherID";


/*    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
    }*/
/*        HttpSession session = req.getSession(false);
        if (!isValidSession(session, SESSION_MARK)) {
            resp.getWriter().write(ERROR_MESSAGE);
            return;
        }
        System.out.println(session.getAttribute(SESSION_MARK));

        String id = req.getParameter("id");
        if (!StringUtils.isEmpty(id) ) processGetRequest(resp, out, UUID.fromString(id),session);*/
    }


/*    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession(false);
        if (!isValidSession(session, SESSION_MARK)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        String name = req.getParameter("name");
        String topic = req.getParameter("topic");
        String description = req.getParameter("description");
        String isVideo = req.getParameter("isVideo");
        String id = req.getParameter("id");
        String videoLink = req.getParameter("videoLink");

        Optional<Subject> subject = service.findById(UUID.fromString(id));
        if (subject.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        System.out.println(!StringUtils.isEmpty(name) && !StringUtils.isEmpty(topic) && !StringUtils.isEmpty(description) && !StringUtils.isEmpty(videoLink));

        if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(topic) && !StringUtils.isEmpty(description)) {
            editService.editDescription(subject.get(), description);
            editService.editTopic(subject.get(), topic);
            editService.editName(subject.get(), name);
            editService.editIsVideo(subject.get(), isVideo);
            editService.editVideoLink(subject.get(),videoLink);
        } else {
            session.setAttribute(EMPTY_FORM_PARAMETER, "true");
        }

        resp.sendRedirect("/subject?id=" + id);*/
          /*  session.setAttribute("name", name);
        }
        if (isIncorrectCorrectParameter(topic)) {
            session.setAttribute(EMPTY_TOPIC, "Topic cannot be empty");
        } else {
            session.setAttribute("topic", topic);
        }
        if (isIncorrectCorrectParameter(description)) {
            session.setAttribute(EMPTY_DESCRIPTION, "description cannot be empty");
        } else {
            session.setAttribute("description", description);
        }
        if (session.getAttribute(EMPTY_NAME) != null || session.getAttribute(EMPTY_TOPIC) != null
                || session.getAttribute(EMPTY_DESCRIPTION) != null) {
            resp.sendRedirect("/subject-after-edit?id=" + subject.get().getId());
            return;*/

  /*  }*/

/*    public void processGetRequest(HttpServletResponse resp, PrintWriter out, UUID id, HttpSession session) throws IOException {
        Optional<Subject> subject = service.findById(id);
        if (subject.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Template template = provider.getTemplate(getServletContext(), "subject-account-data-form-new.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        System.out.println(session.getAttribute(SESSION_MARK));

        Optional<User> user = userService.findById((UUID) session.getAttribute(SESSION_MARK));
        user.ifPresentOrElse(value -> {
                    dataModel.put("user", value);
                    if (value.getRole().equals(ROLE.TEACHER)) dataModel.put("roleTeacher", "TEACHER");
                },
                () -> {
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                });

        dataModel.put("subject", subject.get());
        dataModel.put("isVideo", String.valueOf(subject.get().isVideo()));
        try {
            template.process(dataModel, out);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }*/



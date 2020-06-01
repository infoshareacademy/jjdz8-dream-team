package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.SubjectEditService;
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
import javax.ws.rs.HEAD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.infoshareacademy.servlet.HelperForServlets.*;

@WebServlet("edit-subject")
public class EditSubjectServlet extends HttpServlet {

    @Inject
    private SubjectEditService editService;

    @Inject
    private SubjectService service;

    @Inject
    private TemplateProvider provider;

    public static final String EMPTY_NAME = "emptyName";
    public static final String EMPTY_TOPIC = "emptyTopic";
    public static final String EMPTY_DESCRIPTION = "emptyDescription";

    private static final String SESSION_ATTRIBUTE ="teacherID";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);
        if (!isValidSession(session,SESSION_ATTRIBUTE)) {
            resp.getWriter().write(ERROR_MESSAGE);
            return;
        }
        String id = req.getParameter("id");
        processGetRequest(req, resp, out, UUID.fromString(id));
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession(false);
        if (!isValidSession(session,SESSION_ATTRIBUTE)) {
            resp.getWriter().write(ERROR_MESSAGE);
            return;
        }
        processPostRequest(req, resp, session);

        if (session.getAttribute(EMPTY_NAME) != null || session.getAttribute(EMPTY_TOPIC) != null
                || session.getAttribute(EMPTY_DESCRIPTION) != null) {
            resp.sendRedirect("/edit-subject?id=" + session.getAttribute("subjectId"));
            return;
        }

        resp.sendRedirect("/subject?id=" + session.getAttribute("subjectId"));

    }

    public void processGetRequest(HttpServletRequest req, HttpServletResponse resp, PrintWriter out, UUID id) throws IOException {
        Optional<Subject> subject = service.findById(id);
        if (subject.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Template template = provider.getTemplate(getServletContext(), "subject-account-data.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("subject", subject.get());
        dataModel.put("isVideo", String.valueOf(subject.get().isVideo()));

        HttpSession session = req.getSession(false);

        putCorrectDataToDataModel(EMPTY_NAME, getAttributeValue(session, EMPTY_NAME), dataModel);
        putCorrectDataToDataModel(EMPTY_TOPIC, getAttributeValue(session, EMPTY_TOPIC), dataModel);
        putCorrectDataToDataModel(EMPTY_DESCRIPTION, getAttributeValue(session, EMPTY_DESCRIPTION), dataModel);

        try {
            template.process(dataModel, out);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        invalidateAttributes(session, EMPTY_NAME, EMPTY_TOPIC, EMPTY_DESCRIPTION);
    }

    private void processPostRequest(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, IOException {
        String name = req.getParameter("name");
        String topic = req.getParameter("topic");
        String description = req.getParameter("description");
        String isVideo = req.getParameter("isVideo");
        String id = req.getParameter("id");

        Optional<Subject> subject = service.findById(UUID.fromString(id));
        if (subject.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        session.setAttribute("subjectId", subject.get().getId());

        if (isIncorrectCorrectParameter(name)) {
            session.setAttribute(EMPTY_NAME, "name cannot be empty");
        } else {
            editService.editName(subject.get(), name);
        }

        if (isIncorrectCorrectParameter(topic)) {
            session.setAttribute(EMPTY_TOPIC, "topic cannot be empty");
        } else {
            editService.editTopic(subject.get(), topic);
        }

        if (isIncorrectCorrectParameter(description)) {
            session.setAttribute(EMPTY_DESCRIPTION, "description cannot be empty");

        } else {
            editService.editDescription(subject.get(), description);
        }

        editService.editIsVideo(subject.get(), isVideo);
    }

    private boolean isIncorrectCorrectParameter(String parameter) {
        return (parameter == null || parameter.isEmpty());
    }

    private void invalidateAttributes(HttpSession session, String... attributeNames) {
        for (String attributeName : attributeNames) {
            if (session.getAttribute(attributeName) != null) {
                session.removeAttribute(attributeName);
            }
        }
    }

    private void putCorrectDataToDataModel(String modelKey, String modelValue, Map<String, Object> dataModel) {
        if (!modelValue.isEmpty()) {
            dataModel.put(modelKey, modelValue);
        }
    }

    private String getAttributeValue(HttpSession session, String attributeName) {
        String attribute = "";
        if (session.getAttribute(attributeName) != null) {
            attribute = (String) session.getAttribute(attributeName);
        }
        return attribute;
    }
}

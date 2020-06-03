package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.Service;
import com.infoshareacademy.service.SubjectEditService;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.infoshareacademy.servlet.HelperForServlets.isValidSession;

@WebServlet("/subject-after-edit")
public class SubjectAfterEditServlet extends HttpServlet {

    @Inject
    TemplateProvider provider;

    @Inject
    SubjectService service;

    @Inject
    @Named("TeacherService")
    Service userService;

    @Inject
    private SubjectEditService editService;


    public static final String EMPTY_NAME = "emptyName";

    public static final String EMPTY_TOPIC = "emptyTopic";

    public static final String EMPTY_DESCRIPTION = "emptyDescription";

    public static final String LOGIN_ERROR = "loginError";

    private static final String SESSION_ATTRIBUTE = "teacherID";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        String id = req.getParameter("id");
        if (HelperForServlets.isIncorrectCorrectParameter(id)){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Template template = provider.getTemplate(getServletContext(), "subject-after-edit-servlet.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession(false);
        if (!isValidSession(session, SESSION_ATTRIBUTE)) {
            dataModel.put("message", getAttributeValue(session, LOGIN_ERROR));

        } else {

            service.findById(UUID.fromString(id)).ifPresent(subject -> dataModel.put("subject", subject));

            putCorrectDataToDataModel(EMPTY_NAME, getAttributeValue(session, EMPTY_NAME), dataModel);
            putCorrectDataToDataModel("name", getAttributeValue(session, "name"), dataModel);
            putCorrectDataToDataModel(EMPTY_TOPIC, getAttributeValue(session, EMPTY_TOPIC), dataModel);
            putCorrectDataToDataModel("topic", getAttributeValue(session, "topic"), dataModel);
            putCorrectDataToDataModel(EMPTY_DESCRIPTION, getAttributeValue(session, EMPTY_DESCRIPTION), dataModel);
            putCorrectDataToDataModel("description", getAttributeValue(session, "description"), dataModel);
        }
        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        invalidateAttributes(session, EMPTY_NAME, EMPTY_TOPIC, EMPTY_DESCRIPTION, "name", "description", "topic");
    }

    private void invalidateAttributes(HttpSession session, String... attributeNames) {
        for (String attributeName : attributeNames) {
            if (session.getAttribute(attributeName) != null) {
                session.removeAttribute(attributeName);
            }
        }
    }

    private Optional<Subject> findCorrectSubject(HttpSession session, String attribute) {
        UUID id = (UUID) session.getAttribute(attribute);
        return service.findById(id);
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

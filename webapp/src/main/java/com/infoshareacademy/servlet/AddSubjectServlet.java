package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.security.PasswordResolver;
import com.infoshareacademy.service.Service;
import com.infoshareacademy.service.SubjectEditService;
import com.infoshareacademy.service.SubjectService;
import com.infoshareacademy.service.TeacherService;
import com.infoshareacademy.validation.ParameterValidator;
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

import static com.infoshareacademy.validation.ParameterValidator.isIncorrectCorrectParameter;

@WebServlet("/add-subject")
public class AddSubjectServlet extends HttpServlet {

    @Inject
    TemplateProvider provider;

    @Inject
    SubjectService service;

    @Inject
    SubjectEditService editService;

    @Inject
    @Named("TeacherService")
    Service userService;

    public static final String EMPTY_NAME = "emptyName";

    public static final String EMPTY_TOPIC = "emptyTopic";

    public static final String EMPTY_DESCRIPTION = "emptyDescription";

    public static final String LOGIN_ERROR = "loginError";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("id") == null) {
            String errorMassage = "Please login first";
            printWriter.write(errorMassage);
            return;
        }
        String name = req.getParameter("name");
        String topic = req.getParameter("topic");
        String description = req.getParameter("description");
        boolean isVideo = Boolean.valueOf(req.getParameter("isVideo"));
        UUID teacherId = (UUID) session.getAttribute("id");
        System.out.println(teacherId);

        if (isIncorrectCorrectParameter(name)) {
            session.setAttribute(EMPTY_NAME, "Name cannot be empty");
        } else {
            session.setAttribute("name", name);
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

        System.out.println(session.getAttribute(EMPTY_DESCRIPTION));
        System.out.println(session.getAttribute(EMPTY_NAME));
        System.out.println(session.getAttribute(EMPTY_TOPIC));

        if (session.getAttribute(EMPTY_NAME) != null || session.getAttribute(EMPTY_TOPIC) != null
                || session.getAttribute(EMPTY_DESCRIPTION) != null) {
            resp.sendRedirect("/add-subject");
            return;
        }

        Subject subject = service.createSubject(name, topic, description, isVideo, teacherId);
        service.addNewSubject(subject);
        resp.sendRedirect("/teacher");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), "subject-account-after-edit.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("id") == null) {
            dataModel.put("message", getAttributeValue(session, LOGIN_ERROR));
        }

        Optional<User> user = findCorrectUser(session, "id");
        user.ifPresent(value -> dataModel.put("user", value));

        putCorrectDataToDataModel(EMPTY_NAME, getAttributeValue(session, EMPTY_NAME), dataModel);
        putCorrectDataToDataModel("name", getAttributeValue(session, "name"), dataModel);
        putCorrectDataToDataModel(EMPTY_TOPIC, getAttributeValue(session, EMPTY_TOPIC), dataModel);
        putCorrectDataToDataModel("topic", getAttributeValue(session, "topic"), dataModel);
        putCorrectDataToDataModel(EMPTY_DESCRIPTION, getAttributeValue(session, EMPTY_DESCRIPTION), dataModel);
        putCorrectDataToDataModel("description", getAttributeValue(session, "description"), dataModel);

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

    private Optional<User> findCorrectUser(HttpSession session, String attribute) {
        UUID id = (UUID) session.getAttribute(attribute);
        return userService.findById(id);
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

    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        UUID id = (UUID) req.getSession().getAttribute("id");
        Optional<User> user =service.findById(id);
        if (user.isEmpty()){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Template template = provider.getTemplate(getServletContext(), "add-subject.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("user",user.get());
        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }*/
}

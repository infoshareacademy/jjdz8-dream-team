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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.infoshareacademy.servlet.HelperForServlets.*;
import static com.infoshareacademy.servlet.users.UserLoginServlet.ATTRIBUTE_NAME;
import static com.infoshareacademy.validation.ParameterValidator.isIncorrectCorrectParameter;

@WebServlet("/add-subject")
public class AddSubjectServlet extends HttpServlet {

    @Inject
    TemplateProvider provider;

    @Inject
    SubjectService service;

    @Inject
    Service userService;

    public static final String EMPTY_NAME = "emptyName";

    public static final String EMPTY_TOPIC = "emptyTopic";

    public static final String EMPTY_DESCRIPTION = "emptyDescription";

    public static final String LOGIN_ERROR = "loginError";

    private static final String SESSION_ATTRIBUTE = "teacherID";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        HttpSession session = req.getSession(false);
        if (!isValidSession(session, ATTRIBUTE_NAME)) {
            String errorMassage = "Please login first";
            printWriter.write(errorMassage);
            return;
        }
        String name = req.getParameter("name");
        String topic = req.getParameter("topic");
        String description = req.getParameter("description");
        boolean isVideo = Boolean.parseBoolean(req.getParameter("isVideo"));
        UUID teacherId = (UUID) session.getAttribute(SESSION_ATTRIBUTE);

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

        if (session.getAttribute(EMPTY_NAME) != null || session.getAttribute(EMPTY_TOPIC) != null
                || session.getAttribute(EMPTY_DESCRIPTION) != null) {
            resp.sendRedirect("/add-subject");
            return;
        }

        Subject subject = service.createSubject(name, topic, description, isVideo, teacherId);
        service.addNewSubject(subject);
        resp.sendRedirect("/user-account-information-page.ftlh");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), "subject-after-added-icorect-data.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession(false);
        if (!isValidSession(session, SESSION_ATTRIBUTE)) {
            dataModel.put("message", getAttributeValue(session, LOGIN_ERROR));
        } else {

            findCorrectUser(session).ifPresent(user -> dataModel.put("user", user));
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

    private Optional<User> findCorrectUser(HttpSession session) {
        UUID id = (UUID) session.getAttribute(SESSION_ATTRIBUTE);
        return userService.findById(id);
    }
}

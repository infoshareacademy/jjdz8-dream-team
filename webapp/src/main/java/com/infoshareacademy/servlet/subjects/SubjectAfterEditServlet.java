package com.infoshareacademy.servlet.subjects;

import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.Service;
import com.infoshareacademy.service.SubjectService;
import com.infoshareacademy.servlet.HelperForServlets;
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
import java.util.UUID;

import static com.infoshareacademy.servlet.HelperForServlets.*;
import static com.infoshareacademy.servlet.users.UserLoginServlet.ATTRIBUTE_NAME;

@WebServlet("/subject-after-edit")
public class SubjectAfterEditServlet extends HttpServlet {

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
        if (!isValidSession(session, ATTRIBUTE_NAME)) {
            dataModel.put("message", getAttributeValue(session, LOGIN_ERROR));

        } else {
            service.findById(UUID.fromString(id)).ifPresentOrElse(subject -> dataModel.put("subject", subject),
                    () -> {
                        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    });
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

}

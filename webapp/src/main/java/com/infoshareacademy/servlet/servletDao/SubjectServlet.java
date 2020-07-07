package com.infoshareacademy.servlet.servletDao;

import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.entity.User;
import com.infoshareacademy.freemarker.TemplateCreator;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.servisDao.SubjectService;
import com.infoshareacademy.service.servisDao.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

@WebServlet({"/subject", "/add-subject"})
public class SubjectServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger(AccountInfoServlet.class.getName());

    @Inject
    SubjectService subjectService;

    @Inject
    TemplateProvider provider;

    @Inject
    UserService service;

    public static final String EMPTY_NAME = "Name cannot be empty";

    public static final String EMPTY_TOPIC = "Topic cannot be empty";

    public static final String EMPTY_DESCRIPTION = "description cannot be empty";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String requestURI = req.getRequestURI();

        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession();
        String loginUser = (String) session.getAttribute("login");

        if (StringUtils.isEmpty(loginUser)) {
            LOGGER.info("forbidden, user not login");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            dataModel.put("message", "unauthorised");
            TemplateCreator.createTemplate(dataModel, "home-page.ftlh", resp, provider, getServletContext());
            return;
        }
        Optional<User> user = service.findByNickname(loginUser);
        user.ifPresent(u -> dataModel.put("user", u));
        if (requestURI.equals("/subject")) {
            TemplateCreator.createTemplate(dataModel, "user-account-data-form-before-edit.ftlh", resp, provider, getServletContext());
            return;
        }
        if (requestURI.equals("/add-subject")) {
            TemplateCreator.createTemplate(dataModel, "subject-account-data-form-new.ftlh", resp, provider, getServletContext());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        String name = req.getParameter("name");
        String topic = req.getParameter("topic");
        String description = req.getParameter("description");
        boolean isVideo = Boolean.parseBoolean(req.getParameter("isVideo"));
        String videoLink = req.getParameter("videoLink");
        Long teacherId = Long.valueOf(req.getParameter("id"));

        HttpSession session = req.getSession();

        if (StringUtils.isEmpty(name)) {
            session.setAttribute(EMPTY_NAME, EMPTY_NAME);
        } else {
            session.setAttribute("name", name);
        }
        if (StringUtils.isEmpty(topic)) {
            session.setAttribute(EMPTY_TOPIC, EMPTY_TOPIC);
        } else {
            session.setAttribute("topic", topic);
        }
        if (StringUtils.isEmpty(description)) {
            session.setAttribute(EMPTY_DESCRIPTION, EMPTY_DESCRIPTION);
        } else {
            session.setAttribute("description", description);
        }

        if (session.getAttribute(EMPTY_NAME) != null || session.getAttribute(EMPTY_TOPIC) != null
                || session.getAttribute(EMPTY_DESCRIPTION) != null) {
            resp.sendRedirect("/add-subject");
            return;
        }

        subjectService.createSubject(name, topic, description, videoLink, isVideo, teacherId);
        resp.sendRedirect("/subjects");
    }
}

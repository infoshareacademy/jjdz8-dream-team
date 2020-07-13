package com.infoshareacademy.servlet.servletDao;

import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.entity.User;
import com.infoshareacademy.freemarker.TemplateCreator;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.servisDao.SubjectService;
import com.infoshareacademy.service.servisDao.UserService;
import com.infoshareacademy.servlet.HelperForServlets;
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

@WebServlet("/add-subject")
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

    private static final String EMPTY_VIDEO_LINK = "if you have video materials you have to insert link for them";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String requestURI = req.getRequestURI();

        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession();
        String loginUser = (String) session.getAttribute("login");
        String emptyName = (String) session.getAttribute(EMPTY_NAME);
        String emptyTopic = (String) session.getAttribute(EMPTY_TOPIC);
        String emptyDescription = (String) session.getAttribute(EMPTY_DESCRIPTION);
        String emptyVideoLink = (String) session.getAttribute(EMPTY_VIDEO_LINK);
        String topic = (String) session.getAttribute("topic");
        String name = (String) session.getAttribute("name");
        String description = (String) session.getAttribute("description");

        if (StringUtils.isEmpty(loginUser)) {
            LOGGER.info("forbidden, user not login");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            dataModel.put("message", "unauthorised");
            TemplateCreator.createTemplate(dataModel, "home-page.ftlh", resp, provider, getServletContext());
            return;
        }
        Optional<User> user = service.findByNickname(loginUser);
        user.ifPresent(u -> dataModel.put("user", u));

        if (!StringUtils.isEmpty(name)) dataModel.put("name", name);
        if (!StringUtils.isEmpty(topic)) dataModel.put("topic", topic);
        if (!StringUtils.isEmpty(description)) dataModel.put("description", description);
        if (!StringUtils.isEmpty(emptyName)) dataModel.put("emptyName", EMPTY_NAME);
        if (!StringUtils.isEmpty(emptyTopic)) dataModel.put("emptyTopic", EMPTY_TOPIC);
        if (!StringUtils.isEmpty(emptyDescription)) dataModel.put("emptyDescription", EMPTY_DESCRIPTION);
        if (!StringUtils.isEmpty(emptyVideoLink)) dataModel.put("emptyVideoLink", EMPTY_VIDEO_LINK);
        TemplateCreator.createTemplate(dataModel, "subject-account-data-form-new.ftlh", resp, provider, getServletContext());

        HelperForServlets.invalidateAttributes(session, EMPTY_DESCRIPTION, EMPTY_TOPIC, EMPTY_VIDEO_LINK, EMPTY_NAME);
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
        if (isVideo && StringUtils.isEmpty(videoLink)) {
            session.setAttribute(EMPTY_VIDEO_LINK, EMPTY_VIDEO_LINK);
        }

        if (session.getAttribute(EMPTY_NAME) != null || session.getAttribute(EMPTY_TOPIC) != null
                || session.getAttribute(EMPTY_DESCRIPTION) != null || session.getAttribute(EMPTY_VIDEO_LINK) != null) {
            session.setAttribute("incorrectForm", "true");
            resp.sendRedirect("/add-subject");
            return;
        }

        subjectService.createSubject(name, topic, description, videoLink, isVideo, teacherId);
        resp.sendRedirect("/subjects");
    }


}

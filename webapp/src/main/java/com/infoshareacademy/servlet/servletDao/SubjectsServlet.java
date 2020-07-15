package com.infoshareacademy.servlet.servletDao;

import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.entity.User;
import com.infoshareacademy.freemarker.TemplateCreator;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.servisDao.SubjectService;
import com.infoshareacademy.service.servisDao.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
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
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/subjects")
public class SubjectsServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger(AccountInfoServlet.class.getName());

    @Inject
    TemplateProvider provider;

    @Inject
    UserService service;

    @Inject
    SubjectService subjectService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), "show-all-teacher-subjects.ftlh");
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
        TemplateCreator.createTemplate(dataModel, "show-all-teacher-subjects.ftlh", resp, provider, getServletContext());
        
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String loginUser = (String) session.getAttribute("login");

        if(StringUtils.isEmpty(loginUser)) {
            LOGGER.info("aunauthorized " + LocalDateTime.now());
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            session.setAttribute("message","unAuthorized");
            resp.sendRedirect("/home");
            return;
        }

        String id = req.getParameter("id");
        if (StringUtils.isEmpty(id) || !NumberUtils.isNumber(id)) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Optional<Subject> subject = subjectService.findById(Long.valueOf(id));
        if (subject.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return;
        }

        subjectService.deleteSubject(Long.valueOf(id));
    }
}

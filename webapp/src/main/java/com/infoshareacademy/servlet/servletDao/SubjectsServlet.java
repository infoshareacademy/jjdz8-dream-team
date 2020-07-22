package com.infoshareacademy.servlet.servletDao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.Dto.SubjectDto;
import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.entity.User;
import com.infoshareacademy.freemarker.TemplateCreator;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.servisDao.SubjectService;
import com.infoshareacademy.service.servisDao.UserService;
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
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.infoshareacademy.resolver.InputResolver.inputStreamToString;

@WebServlet({"/subjects","/subjects/edit"})
public class SubjectsServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger(SubjectsServlet.class.getName());

    @Inject
    TemplateProvider provider;

    @Inject
    UserService service;

    @Inject
    SubjectService subjectService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String id = req.getParameter("id");
        String afterSearch = req.getParameter("afterSearch");


        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession();
        String loginUser = (String) session.getAttribute("login");
        String incorrectForm = (String) session.getAttribute("incorrectForm");

        if (StringUtils.isEmpty(loginUser)) {
            LOGGER.info("forbidden, user not login");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            dataModel.put("message", "unauthorised");
            TemplateCreator.createTemplate(dataModel, "home-page.ftlh", resp, provider, getServletContext());

            return;
        }

        Optional<User> user = service.findByNickname(loginUser);
        user.ifPresent(u -> dataModel.put("user", u));

        if (!StringUtils.isEmpty(id)){
            subjectService.findById(Long.valueOf(id)).ifPresent(subject-> dataModel.put("subject", subject));
            if (req.getRequestURI().equals("/subjects/edit") || !StringUtils.isEmpty(incorrectForm)){
                if (!StringUtils.isEmpty(incorrectForm)) dataModel.put("incorrectForm", "pola nie mogą pozostać puste");
                TemplateCreator.createTemplate(dataModel,"edit-subject-form.ftlh",resp,provider,getServletContext());
                session.removeAttribute("incorrectForm");
                return;
            }
            if (!StringUtils.isEmpty(afterSearch)) dataModel.put("afterSearch","true");
            TemplateCreator.createTemplate(dataModel,"subject-information-page-new.ftlh",resp,provider,getServletContext());
            return;
        }
        TemplateCreator.createTemplate(dataModel, "show-all-teacher-subjects.ftlh", resp, provider, getServletContext());

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String loginUser = (String) session.getAttribute("login");

        if (StringUtils.isEmpty(loginUser)) {
            LOGGER.info("aunauthorized " + LocalDateTime.now());
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            session.setAttribute("message", "unAuthorized");
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

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = inputStreamToString(req.getInputStream());
        ObjectMapper mapper = new ObjectMapper();

        SubjectDto subjectDto = mapper.readValue(body, SubjectDto.class);

        HttpSession session = req.getSession();


        if (subjectDto != null) {
            String name = subjectDto.getName();
            String topic = subjectDto.getTopic();
            String description = subjectDto.getDescription();

            if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(topic) && !StringUtils.isEmpty(description)) {
                subjectService.updateSubject(subjectDto);
                return;
                }
            }
            session.setAttribute("incorrectForm","true");
        }

    }


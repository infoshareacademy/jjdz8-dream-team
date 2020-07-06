package com.infoshareacademy.servlet.servletDao;



import com.infoshareacademy.entity.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.servisDao.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger(AccountInfoServlet.class.getName());

    @Inject
    UserService userService;

    @Inject
    TemplateProvider provider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        HttpSession session = req.getSession(false);

        Template template = provider.getTemplate(getServletContext(), "user-account-data-form-before-edit.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        Cookie[] cookies = req.getCookies();

        Optional<Cookie> cookie = List.of(cookies)
                .stream()
                .filter(c -> c.getName().equals("nickname"))
                .findFirst();

        if (cookie.isPresent()) {
            Optional<User> user = userService.findByNickname(cookie.get().getValue());
            user.ifPresent(u->dataModel.put("user", u));
        } else {
            LOGGER.info("forbidden, user not login");
        }

/*        if (!isValidSession(session, SESSION_MARK)) {
            dataModel.put("message", "please login first");
        } else {

            Optional<User> user = service.findById((UUID) session.getAttribute(SESSION_MARK));
            user.ifPresentOrElse(value -> {
                        dataModel.put("user", value);
                        if (value.getRole().equals(ROLE.TEACHER)) dataModel.put("roleTeacher", "TEACHER");
                    },
                    () -> {
                        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    });

            if (user.get().getRole().equals(ROLE.TEACHER)) {
                List<Subject> subjects;
                subjects = subjectRepository.findAllSubjectForTeacher(user.get().getId());

                if (subjects.size() > 0) {
                    dataModel.put("subjects", subjects);
                }
            }*/

        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

/*    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute(SESSION_MARK) == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        String id = req.getParameter("id");
        if (StringUtils.isEmpty(id)) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Optional<User> user = service.findById(UUID.fromString(id));
        if (user.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        service.delete(user.get());
        req.getSession(false).invalidate();
    }*/
}

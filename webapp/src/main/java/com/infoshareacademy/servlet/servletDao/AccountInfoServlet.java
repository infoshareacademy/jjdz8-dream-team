package com.infoshareacademy.servlet.servletDao;


import com.infoshareacademy.domain.ROLE;
import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.entity.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.Service;
import com.infoshareacademy.service.SubjectService;
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
import java.util.*;

import static com.infoshareacademy.servlet.users.UserLoginServlet.SESSION_MARK;

@WebServlet("/account-info")
public class AccountInfoServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger(AccountInfoServlet.class.getName());

    @Inject
    private SubjectService subjectService;

    @Inject
    private TemplateProvider provider;

   @Inject
    UserService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), "user-account-information-page.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        Cookie[] cookies = req.getCookies();

        Optional<Cookie> cookie = List.of(cookies)
                .stream()
                .filter(c -> c.getName().equals("nickname"))
                .findFirst();

        if (cookie.isPresent()) {
            Optional<User> user = service.findByNickname(cookie.get().getValue());
            user.ifPresent(u->dataModel.put("user", u));
        } else {
            LOGGER.info("forbidden, user not login");
        }

        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            LOGGER.info(e.getLocalizedMessage());
        }

    }
}

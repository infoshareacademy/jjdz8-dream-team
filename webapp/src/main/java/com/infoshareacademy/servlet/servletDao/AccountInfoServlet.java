package com.infoshareacademy.servlet.servletDao;


import com.infoshareacademy.entity.User;
import com.infoshareacademy.freemarker.TemplateCreator;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.servisDao.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;


@WebServlet("/account-info")
public class AccountInfoServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger(AccountInfoServlet.class.getName());

    @Inject
    private TemplateProvider provider;

    @Inject
    UserService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession();
        String loginUser = (String) session.getAttribute("login");

        if (!StringUtils.isEmpty(loginUser)) {
            Optional<User> user = service.findByNickname(loginUser);
            user.ifPresent(u -> dataModel.put("user", u));
            TemplateCreator.createTemplate(dataModel, "user-account-information-page.ftlh", resp, provider, getServletContext());
        } else {
            LOGGER.info("forbidden, user not login");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            dataModel.put("message", "unauthorised");
            TemplateCreator.createTemplate(dataModel, "home-page.ftlh", resp, provider, getServletContext());
        }

    }
}

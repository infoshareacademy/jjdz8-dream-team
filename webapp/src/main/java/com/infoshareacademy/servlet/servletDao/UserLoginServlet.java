package com.infoshareacademy.servlet.servletDao;

import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.servisDao.LoginService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger(UserLoginServlet.class.getName());

    @Inject
    LoginService service;

    @Inject
    private TemplateProvider provider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        String message = (String) req.getSession().getAttribute("incorrect");
        System.out.println(message);

        Template template = provider.getTemplate(getServletContext(), "login.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        if (!StringUtils.isEmpty(message)){
            dataModel.put("incorrect", "incorrect");
            req.getSession().invalidate();
        }

        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String nickName = req.getParameter("nickName");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        if (StringUtils.isEmpty(nickName) || StringUtils.isEmpty(password)) {
            session.setAttribute("incorrect","incorrect");
            resp.sendRedirect("/login");
            return;
        }

        if(service.isCorrectPasswordForUser(nickName,password)) {
            resp.setStatus(HttpServletResponse.SC_FOUND);
            session.setAttribute("login", nickName);
            session.setMaxInactiveInterval(900);
            resp.sendRedirect("/account-info");

        } else {
            session.setAttribute("incorrect","incorrect");
            LOGGER.info("incorrect login data for user"+nickName);
            resp.sendRedirect("/login");
        }
    }
}

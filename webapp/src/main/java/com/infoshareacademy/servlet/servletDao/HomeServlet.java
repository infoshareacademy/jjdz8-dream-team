package com.infoshareacademy.servlet.servletDao;


import com.infoshareacademy.freemarker.TemplateProvider;
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

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private static Logger LOGGER = LogManager.getLogger(AccountInfoServlet.class.getName());

    @Inject
    private TemplateProvider provider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        HttpSession session = req.getSession();

        Template template = provider.getTemplate(getServletContext(), "home-page.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        String anAuthorizedAccess =(String) session.getAttribute("message");

        if (!StringUtils.isEmpty(anAuthorizedAccess)){
            dataModel.put("message", anAuthorizedAccess);
        }
        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            LOGGER.info(e.getLocalizedMessage());
        }
    }
}

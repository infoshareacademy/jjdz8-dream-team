package com.infoshareacademy.freemarker;

import com.infoshareacademy.servlet.servletDao.AccountInfoServlet;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class TemplateCreator {

    private static Logger LOGGER = LogManager.getLogger(AccountInfoServlet.class.getName());


    public static void createTemplate(Map<String, Object> dataModel, String templateName, HttpServletResponse resp,
                                      TemplateProvider provider, ServletContext context) throws ServletException, IOException {
        Template template = provider.getTemplate(context, templateName);
        try {
            template.process(dataModel, resp.getWriter());
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            LOGGER.info(e.getLocalizedMessage());
        }
    }
}

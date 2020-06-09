package com.infoshareacademy.servlet.subjects;

import com.infoshareacademy.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

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

import static com.infoshareacademy.servlet.HelperForServlets.ERROR_MESSAGE;
import static com.infoshareacademy.servlet.HelperForServlets.isValidSession;
import static com.infoshareacademy.servlet.users.UserLoginServlet.ATTRIBUTE_NAME;

@WebServlet("/search")
public class SearchSubject extends HttpServlet {

    @Inject
    TemplateProvider provider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), "search-page.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession(false);
        if (!isValidSession(session,ATTRIBUTE_NAME)) {
            dataModel.put("message", ERROR_MESSAGE);
        }
        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}

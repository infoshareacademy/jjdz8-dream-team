package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.SubjectService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/filter-subjects")
public class FilterSubjectsServlet extends HttpServlet {


    @Inject
    private TemplateProvider provider;

    @Inject
    private SubjectService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        String filter = req.getParameter("filter");
        if (HelperForServlets.isIncorrectCorrectParameter(filter)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Template template = provider.getTemplate(getServletContext(), "all-subject-list.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        List<Subject> subjects;

        if (filter.equals("all")) {
            subjects = service.findAll();
            dataModel.put("subjects",subjects);
        }
      /*  if (subjects == null || subjects.size() == 0) {
            dataModel.put("message", "no subjects found");
        } else {
            dataModel.put("subjects", subjects);
        }*/
        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}

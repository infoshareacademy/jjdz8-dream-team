package com.infoshareacademy.servlet.users;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/subject")
public class SubjectServlet extends HttpServlet {

    @Inject
    SubjectService service;
    @Inject
    TemplateProvider provider;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String id = req.getParameter("id");
        processRequest(resp, out, UUID.fromString(id));
        req.getSession().setAttribute("subjectId", UUID.fromString(id));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession(false);
        String errorMassage;
        if (session.getAttribute("id") == null) {
            errorMassage = "Please login first";
            out.write(errorMassage);
            return;
        }
        String id = req.getParameter("id");
        if (id == null || id.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "something goes wrong");
            return;
        }
        processRequest(resp, out, UUID.fromString(id));

    }

    public void processRequest(HttpServletResponse resp, PrintWriter out, UUID id) throws IOException {
        Optional<Subject> subject = service.findById(id);
        if (subject.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Template template = provider.getTemplate(getServletContext(), "subject-information-page.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("subject", subject.get());
        dataModel.put("range", subject.get().getDescription());
        dataModel.put("isVideo", String.valueOf(subject.get().isVideo()));
        try {
            template.process(dataModel, out);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null || id.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Optional<Subject> subject = service.findById(UUID.fromString(id));
        if (subject.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        service.delete(subject.get());
    }
}

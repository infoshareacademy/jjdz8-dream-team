package com.infoshareacademy.servlet;

import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.SubjectService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/add-subject")
public class AddSubjectServlet extends HttpServlet {

    @Inject
    TemplateProvider provider;

    @Inject
    SubjectService service;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        HttpSession session=req.getSession(false);
        if(session==null) {
            String errorMassage = "Please login first";
            printWriter.write(errorMassage);
            return;
        }
        String name = req.getParameter("name");
        String topic = req.getParameter("topic");
        String description = req.getParameter("description");
        boolean isVideo = Boolean.valueOf(req.getParameter("isVideo"));
        UUID teacherId = (UUID) session.getAttribute("id");
        service.addNewSubject(name,topic,description,isVideo,teacherId);
        resp.sendRedirect("/teacher");
    }

    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        UUID id = (UUID) req.getSession().getAttribute("id");
        Optional<User> user =service.findById(id);
        if (user.isEmpty()){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Template template = provider.getTemplate(getServletContext(), "add-subject.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("user",user.get());
        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }*/
}

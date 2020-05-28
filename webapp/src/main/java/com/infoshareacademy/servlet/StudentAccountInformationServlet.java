package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.Service;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.inject.Named;
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
import java.util.Optional;
import java.util.UUID;

@WebServlet("/student-account-information-servlet")
public class StudentAccountInformationServlet extends HttpServlet {

    @Inject
    @Named("StudentService")
    private Service service;

    @Inject
    private TemplateProvider provider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        HttpSession session = req.getSession(false);
        String errorMassage;
        if (session==null || session.getAttribute("id") == null) {
            errorMassage = "Please login first";
            printWriter.write(errorMassage);
            return;
        }

        Template template = provider.getTemplate(getServletContext(), "student-account-data-form.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        String massage;
        UUID id;
        Optional<User> user;

        id = (UUID) session.getAttribute("id");
        System.out.println(id);
        user = service.findById(id);
        System.out.println(user.get().getNickName());
        if (user.isPresent()) {
            dataModel.put("user", user.get());
        } else {
            massage = "Please login first";
            printWriter.println(massage);
            dataModel.put("message", massage);
        }
        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}

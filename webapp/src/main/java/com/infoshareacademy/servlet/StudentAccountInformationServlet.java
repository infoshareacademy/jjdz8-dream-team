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
import java.util.UUID;

import static com.infoshareacademy.servlet.HelperForServlets.*;

@WebServlet("/student-account-information-servlet")
public class StudentAccountInformationServlet extends HttpServlet {

    @Inject
    @Named("StudentService")
    private Service service;

    @Inject
    private TemplateProvider provider;

    private static final String SESSION_ATTRIBUTE ="studentID";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Template template = provider.getTemplate(getServletContext(), "student-account-data-form-new.ftlh");
        Map<String, Object> dataModel = new HashMap<>();

        HttpSession session = req.getSession(false);
        if (!isValidSession(session, SESSION_ATTRIBUTE)) {
            printWriter.write(ERROR_MESSAGE);
            return;
        }

        UUID id = (UUID) session.getAttribute(SESSION_ATTRIBUTE);
        service.findById(id).ifPresentOrElse(user -> dataModel.put("user", user),
                () -> dataModel.put("errorMessage", ERROR_MESSAGE));

        try {
            template.process(dataModel, printWriter);
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}

package com.infoshareacademy.servlet.users;

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


@WebServlet("/user-to-edit")
public class UserToEdit extends HttpServlet {

    @Inject
    private TemplateProvider provider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        HttpSession session = req.getSession(false);
        if (session.getAttribute("studentID") != null) {
            req.getRequestDispatcher("/student-account-information-servlet").forward(req,resp);
        }
        if (session.getAttribute("teacherID") != null) {
            req.getRequestDispatcher("teacher-account-information").forward(req,resp);
        }

    }
}

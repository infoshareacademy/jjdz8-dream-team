package com.infoshareacademy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/logout")
public class UserLogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html,charset=UTF8");
        PrintWriter out=resp.getWriter();

        HttpSession session = req.getSession(false);
/*        session.removeAttribute("teacherID");
        session.removeAttribute("teacherID");*/
        session.invalidate();

        out.close();
        resp.sendRedirect("page-after-logout.jsp");
    }
}

package com.infoshareacademy.servlet.servletDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;


@WebServlet("/logout")
public class UserLogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html,charset=UTF8");

        HttpSession session = req.getSession();

        session.invalidate();

        resp.sendRedirect("/home");
        Cookie cookie = new Cookie("logout", "true");
        cookie.setMaxAge(2);
        resp.addCookie(cookie);
    }
}

package com.infoshareacademy.servlet.users;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.service.Service;
import org.apache.commons.lang.StringUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    @Inject
    private Service service;

    public static final String ATTRIBUTE_NAME = "userId";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String nickName = req.getParameter("nickName");

        if (StringUtils.isEmpty(nickName)) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Optional<User> user = service.findByNickName(nickName);
        if (user.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        HttpSession session = req.getSession(true);
        session.setAttribute(ATTRIBUTE_NAME, user.get().getId());
        resp.sendRedirect("/account-info");
    }
}
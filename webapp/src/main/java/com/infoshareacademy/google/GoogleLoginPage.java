package com.infoshareacademy.google;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.infoshareacademy.service.servisDao.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/log")
public class GoogleLoginPage extends HttpServlet {

    @Inject
    UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            String idToken = req.getParameter("id_token");
            GoogleIdToken.Payload payLoad = IdTokenVerifierAndParser.getPayload(idToken);
            String nickName = (String) payLoad.get("name");
            String email = payLoad.getEmail();


            HttpSession session = req.getSession(true);
            if (userService.findByNickname(nickName).isEmpty()) {
                userService.createUser(nickName, email, UUID.randomUUID().toString(), null);
                resp.setStatus(HttpServletResponse.SC_CREATED);
            }
            session.setAttribute("login", nickName);
            session.setMaxInactiveInterval(900);
            resp.sendRedirect("/account-info");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

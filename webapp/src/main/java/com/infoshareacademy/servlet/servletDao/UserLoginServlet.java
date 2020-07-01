package com.infoshareacademy.servlet.servletDao;

import com.infoshareacademy.service.servisDao.UserService;
import org.apache.commons.lang.StringUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    @Inject
    UserService service;

    public static final String SESSION_MARK = "userId";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String nickName = req.getParameter("nickName");

        if (StringUtils.isEmpty(nickName)) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }


        service.findByNickname(nickName).
                ifPresentOrElse(u -> {
                            req.getSession(true).setAttribute(SESSION_MARK, u.getId());
                            try {
                                resp.sendRedirect("/account-info");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        },
                        () -> resp.setStatus(HttpServletResponse.SC_NOT_FOUND));
    }
}

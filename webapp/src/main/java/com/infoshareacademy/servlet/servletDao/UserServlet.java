package com.infoshareacademy.servlet.servletDao;



import com.infoshareacademy.entity.User;
import com.infoshareacademy.service.servisDao.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/daoUser")
public class UserServlet extends HttpServlet {
    @Inject
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.createUser();
        Optional<User> user = userService.findByNickname("Adam");
        user.ifPresent(u-> {
            try {
                resp.getWriter().println(u.getNickName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}

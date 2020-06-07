package com.infoshareacademy.servlet.users;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.domain.Users;
import com.infoshareacademy.service.UserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = { "/user" })
public class UserServlet extends HttpServlet {

    @Inject UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forwardUsersList(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("add".equals(action)) {
            addUserAction(req, resp);
        } else {
            forwardAddUserForm(req, resp);
        }
    }

    private void forwardUsersList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/list-users.jsp");
        Users users = userService.getAllUsers();
        req.setAttribute("userList", users);
        dispatcher.forward(req, resp);
    }

    private void forwardAddUserForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/new-user.jsp");
        dispatcher.forward(req, resp);
    }

    private void addUserAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Long id = Long.parseLong(req.getParameter("id"));
        // req.setAttribute("id", id);

        String name = req.getParameter("name");
        req.setAttribute("name", name);

        double grade = Double.parseDouble(req.getParameter("grade"));
        req.setAttribute("grade", grade);
        User user = new User(name, grade);
        //long idUser = UserServiceEm.addUser(user);

        userService.addUser(user);
        forwardUsersList(req, resp);
    }
}




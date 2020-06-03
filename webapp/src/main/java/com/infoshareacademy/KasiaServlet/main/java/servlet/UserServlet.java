package com.infoshareacademy.KasiaServlet.main.java.servlet;

import com.google.gson.Gson;

import com.infoshareacademy.KasiaServlet.main.java.domain.User;
import com.infoshareacademy.KasiaServlet.main.java.service.UserServiceEm;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "UserServlet",
        urlPatterns = {"/user"}
)
public class UserServlet extends HttpServlet {

    UserServiceEm userServiceEm = new UserServiceEm();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<User> result = userServiceEm.getAllUsers();
        forwardListUser(req, resp, result);

    }


    private void forwardListUser(HttpServletRequest req, HttpServletResponse resp, List userList)
            throws ServletException, IOException {
        String nextJSP = "/jsp/list-users.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        req.setAttribute("userList", userList);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                addUserAction(req, resp);
                break;
        }

    }
    private void addUserAction(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       // Long id = Long.parseLong(req.getParameter("id"));
    // req.setAttribute("id", id);

        String name = req.getParameter("name");
        req.setAttribute("name", name);

        double grade = Double.parseDouble(req.getParameter("grade"));
        req.setAttribute("grade",grade);
        User user = new User(name, grade);
        //long idUser =UserServiceEm.addUser(user);
        List<User> userList =UserServiceEm.getAllUsers();
        userList.add(new User(name,grade));
        forwardListUser(req, resp, userList);

//Proba zapisu requestu
        File myObj = new File("users.json");
        Writer writer = new FileWriter(myObj);


        writer.flush();

        List<User> users = new ArrayList<>();

        users.add(new User("Patryk",5));
        users.add(new User("Ela",4));
        users.add(new User("Marek",6));

        new Gson().toJson(users, writer);

    }

    }




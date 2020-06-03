package com.infoshareacademy.KasiaServlet.main.java.service;


import com.infoshareacademy.KasiaServlet.main.java.domain.User;
import com.infoshareacademy.KasiaServlet.main.java.storage.UserDb;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class UserServiceEm {

    static List<User> userList = UserDb.getRepository();

    public static List<User> getAllUsers() {
        return userList;
    }

    public static long addUser(User user) {
        userList.add(user);
        return user.getId();
    }}



package com.infoshareacademy;


import com.infoshareacademy.service.servisDao.UserService;

public class Main {
    public static void main(String[] args) {

        UserService service = new UserService();
        System.out.println(service.findById(7L).get());
    }
}


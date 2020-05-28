package com.infoshareacademy;

import com.infoshareacademy.menu.MenuService;
import com.infoshareacademy.security.PasswordCoding;

public class App {
    public static void main(String[] args) {

        System.out.println(PasswordCoding.passwordHashing("kamila90@"));
    }
}

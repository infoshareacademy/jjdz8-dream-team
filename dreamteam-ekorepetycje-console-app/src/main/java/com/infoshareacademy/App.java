package com.infoshareacademy;

import com.infoshareacademy.menu.MainMenu;
import com.infoshareacademy.menu.MenuService;
import com.infoshareacademy.users.TeacherService;

public class App {
    public static void main(String[] args) {

        MainMenu menu = new MainMenu();
        MenuService.uploadCorrectUserInput();
        MenuService.chooseOptionMainMenu();

    }
}

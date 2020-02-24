package com.infoshareacademy.menu;

public class MainMenu {

    public static final  String menu = "Main menu";

    static String[] menuOptions = {"Teacher! Enter your data", "Change your data",
            "Searching for subject tutoring", "Show teacher ranking "};

    public static void showMenu() {
        System.out.println("---------------------------------");
        System.out.println("------------" + menu + "------------");
        System.out.println("---------------------------------");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println(i + 1 + ". " + menuOptions[i]);
        }
        System.out.println("---------------------------------");
    }
}

package com.infoshareacademy.menu;

public class MainMenu {

    static String menu = "Main menu";

    static String[] menuOptions = {"1. Teacher! Enter your data","2. Change your data",
            "3. Searching for subject tutoring", "4. Show teacher ranking "};

    public MainMenu() {
        showMenu();
    }

    public static void showMenu() {
        System.out.println("---------------------------------");
        System.out.println("------------"+menu+"------------");
        System.out.println("---------------------------------");
        for (String option : menuOptions) {
            System.out.println(option);
        }
        System.out.println("---------------------------------");
    }



}

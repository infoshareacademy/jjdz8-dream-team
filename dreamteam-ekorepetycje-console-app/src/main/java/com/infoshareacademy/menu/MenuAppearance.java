package com.infoshareacademy.menu;

public class MenuAppearance {

    private static final String menu = "Main menu";

    private static final String dataEditMenu = "Edit your account";

    public static String[] mainMenuOptions = {"Teacher! Enter your data", "Change your data",
            "Searching for subject tutoring", "Show teacher ranking "};

    public static String[] editMenuOptions = {"Edit nickname", "Edit subject",
            "Add new subject "};

    public static void showMainMenu() {
        System.out.println("---------------------------------");
        System.out.println("------------" + menu + "------------");
        System.out.println("---------------------------------");
        for (int i = 0; i < mainMenuOptions.length; i++) {
            System.out.println(i + 1 + ". " + mainMenuOptions[i]);
        }
        System.out.println("---------------------------------");
    }

    public static void showDataEditMenu() {
        System.out.println("------------------------------------------------");
        System.out.println("-------------" + dataEditMenu + "------------------");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < editMenuOptions.length; i++) {
            System.out.println(i + 1 + ". " + editMenuOptions[i]);
        }
        System.out.println("------------------------------------------------");
    }
}

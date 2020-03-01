package com.infoshareacademy.menu;

public class MenuAppearance {

    private static final String menu = "Main menu";

    private static final String dataEditMenu = "Edit your account";

    private static final String subjectEditMenu = "Edit your subject";

    public static String[] mainMenuOptions = {"Teacher! Create your account", "Change your data",
            "Searching for subject tutoring", "Show teacher ranking ", "Exit application"};

    public static String[] editMenuOptions = {"Edit nickname", "Edit password", "Edit subject",
            "Add new subject ", "Return to main menu"};

    public static String[] subjectEditOptions = { "Edit subject name", "Edit subject topic",
            "Edit subject range","Edit video - lecture information"};

    public static void showMainMenu() {
        System.out.println("************************************");
        System.out.println("            " + menu);
        System.out.println("************************************");
        for (int i = 0; i < mainMenuOptions.length; i++) {
            System.out.println(i + 1 + ". " + mainMenuOptions[i]);
        }
        System.out.println("*************************************");
    }

    public static void showDataEditMenu() {
        System.out.println("***************************************");
        System.out.println("            " + dataEditMenu);
        System.out.println("***************************************");
        for (int i = 0; i < editMenuOptions.length; i++) {
            System.out.println(i + 1 + ". " + editMenuOptions[i]);
        }
        System.out.println("****************************************");
    }

    public static void showSubjectDataToEdit() {
        System.out.println("***************************************");
        System.out.println("            " + subjectEditMenu);
        System.out.println("***************************************");
        for (int i = 0; i < subjectEditOptions.length; i++) {
            System.out.println(i + 1 + ". " + subjectEditOptions[i]);
        }
        System.out.println("****************************************");
    }

}

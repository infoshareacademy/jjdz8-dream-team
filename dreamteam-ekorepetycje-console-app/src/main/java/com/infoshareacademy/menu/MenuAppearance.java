package com.infoshareacademy.menu;

public class MenuAppearance {

    private static final String MENU = "Main menu";

    private static final String DATA_EDIT_MENU = "Edit your account";

    private static final String SUBJECT_EDIT_MENU = "Edit your subject";

    private static final String TERMS_FROM_CALENDARS_MENU = "Term from calendars";

    public static final String[] MAIN_MENU_OPTIONS = {"Teacher! Create your account", "Change your data",
            "Searching for subject tutoring", "Show teacher ranking ", "Show teachers and subjects terms", "Exit application"};

    public static final String[] EDIT_MENU_OPTIONS = {"Edit nickname", "Edit password", "Edit subject",
            "Add new subject ", "Return to main menu"};

    public static final String[] SUBJECT_EDIT_OPTIONS = {"Edit subject name", "Edit subject topic",
            "Edit subject range", "Edit video - lecture information", "Return to main Menu"};

    public static final String[] TERMS_FROM_CALENDARS_OPTIONS = {"Show all terms of specific teacher", "Show all terms of specific subject",
            "Show all terms", "Return to main Menu"};

    public static void showMainMenu() {
        displayFrame(MENU, MAIN_MENU_OPTIONS);
    }

    public static void showDataEditMenu() {
        displayFrame(DATA_EDIT_MENU, EDIT_MENU_OPTIONS);
    }

    public static void showSubjectDataToEdit() {
        displayFrame(SUBJECT_EDIT_MENU, SUBJECT_EDIT_OPTIONS);
    }

    public static void showTermsMenu() {
        displayFrame(TERMS_FROM_CALENDARS_MENU, TERMS_FROM_CALENDARS_OPTIONS);
    }

    private static void displayFrame(String header, String[] options) {
        System.out.println("*********************************************************************");
        System.out.println("                            " + header);
        System.out.println("*********************************************************************");
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + 1 + ". " + options[i]);
        }
        System.out.println("*********************************************************************");
    }
}

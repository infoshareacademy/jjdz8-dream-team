package com.infoshareacademy.menu;

import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.users.TeacherAccount;

public class MenuService {

    public static void appStart() {
        MenuAppearance.showMainMenu();
        MenuOption.chooseOptionMainMenu();
    }

    public static void exitApplication() {
        System.out.println("Do you really want exit application? Yes/No");
        String choice = UserInput.uploadString();
        while (true) {
            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("see you next time");
                return;
            }
            if (choice.equalsIgnoreCase("No")) {
                returnToMainMenu();
                return;

            } else {
                System.out.println("please enter yes/no");
                choice = UserInput.uploadString();
            }
        }
    }

    public static void returnToMainMenu() {
        appStart();
    }

    public static void returnToDataEditMenu(TeacherAccount account) {
        MenuAppearance.showDataEditMenu();
        MenuOption.chooseDataToEdit(account);
    }


}

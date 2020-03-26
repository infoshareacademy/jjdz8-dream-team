package com.infoshareacademy.menu;

import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.userOutput.CommandPrinter;
import com.infoshareacademy.users.TeacherAccount;

import static com.infoshareacademy.menu.MenuOption.uploadCorrectUserInput;

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
                break;
            }
            if (choice.equalsIgnoreCase("No")) {
                returnToMainMenu();
                break;

            }
            System.out.println("please enter yes/no");
            choice = UserInput.uploadString();
        }
    }

    public static void returnToMainMenu() {
        appStart();
    }

    public static void returnToDataEditMenu(TeacherAccount account) {
        MenuAppearance.showDataEditMenu();
        MenuOption.chooseDataToEdit(account);
    }

    public static void returnToMainMenuFromTeachersRates() {
        CommandPrinter.returnToMainMenu();
        uploadCorrectUserInput(1);
        MenuService.returnToMainMenu();
    }
}

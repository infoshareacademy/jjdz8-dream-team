package com.infoshareacademy.menu;

import com.infoshareacademy.userInput.UserInput;

public class MenuService {

    public void appStart() {
        MenuAppearance.showMainMenu();
        MenuOption.chooseOptionMainMenu();
        exitApplication();
    }

    public void exitApplication() {
        System.out.println("Do you want exit application? Yes/No");
        String choice = UserInput.uploadString();
        while (!choice.equalsIgnoreCase("yes") || !choice.equalsIgnoreCase("no")) {
            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("see you next time");
                break;
            }
            if (choice.equalsIgnoreCase("No")) {
                returnToMainMenu();

            } else {
                System.out.println("please enter yes/no");
                choice = UserInput.uploadString();
            }
        }
    }

    public void returnToMainMenu() {
        appStart();
    }
}

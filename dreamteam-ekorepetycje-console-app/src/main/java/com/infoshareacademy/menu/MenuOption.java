package com.infoshareacademy.menu;


import com.infoshareacademy.lectures.SubjectService;
import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.users.TeacherAccount;
import com.infoshareacademy.users.TeacherAccountEditor;
import com.infoshareacademy.users.TeacherService;

public class MenuOption {

    public static void chooseOptionMainMenu() {
        int userChoice = uploadCorrectUserInput(MenuAppearance.mainMenuOptions.length);
        TeacherService teacherService = new TeacherService();
        SubjectService subjectService = new SubjectService();
        switch (userChoice) {
            case 1: {
                teacherService.createTeacherAccount();
                break;
            }
            case 2: {
                teacherService.editTeacherAccount();

                break;
            }
            case 3: {
                subjectService.searchSubject();
                break;
            }
            case 4: {
                teacherService.showBestRatedTeachers();
                break;
            }
            case 5: {
                MenuService menuService = new MenuService();
                menuService.exitApplication();
            }
        }
    }

    public static void chooseDataToEdit(TeacherAccount account) {
        int userChoice = uploadCorrectUserInput(MenuAppearance.editMenuOptions.length);
        TeacherAccountEditor editor = new TeacherAccountEditor(account);
        switch (userChoice) {
            case 1: {
                editor.editTeacherNickname(account);
                break;
            }
            case 2 :{
                editor.editTeacherPassword(account);
            }
            case 3: {
                editor.editTeachersSubjects(account);
                break;
            }
            case 4: {
                editor.addNewSubject(account);
                break;
            }
        }
    }

    private static int uploadCorrectUserInput(int maxRange) {
        System.out.println("Please choose what do you want to do");
        int userChoice = UserInput.upLoadInt();
        while (userChoice < 1 || userChoice > maxRange) {
            System.out.println("Incorrect choice. Try again with number between 1-" + maxRange);
            userChoice = UserInput.upLoadInt();
        }

        return userChoice;
    }

    public static void returnToMainMenu() {
        MenuAppearance.showMainMenu();
        MenuOption.chooseOptionMainMenu();
    }

}

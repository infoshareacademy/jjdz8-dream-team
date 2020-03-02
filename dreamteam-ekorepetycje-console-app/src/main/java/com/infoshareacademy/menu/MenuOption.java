package com.infoshareacademy.menu;


import com.infoshareacademy.lectures.*;
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
                MenuService.exitApplication();
            }
        }
    }

    public static void chooseDataToEdit(TeacherAccount account) {
        int userChoice = uploadCorrectUserInput(MenuAppearance.editMenuOptions.length);
        TeacherAccountEditor editor = new TeacherAccountEditor(account);
        SubjectAccountEditor subjectEditor = new SubjectAccountEditor();
        switch (userChoice) {
            case 1: {
                editor.editTeacherNickname();
                break;
            }
            case 2: {
                editor.editTeacherPassword();
            }
            case 3: {
                subjectEditor.editSubjects(account);
                break;
            }
            case 4: {
                SubjectAccountCreator accountCreator = new SubjectAccountCreator();
                accountCreator.createSubjectsAccount(account.getTeacher().getId());
                MenuService.returnToDataEditMenu(account);
                break;
            }
            case 5: {
                MenuService.returnToMainMenu();
                break;
            }
        }
    }

    public static int uploadCorrectUserInput(int maxRange) {
        System.out.println("Please choose one");
        int userChoice = UserInput.upLoadInt();
        while (userChoice < 1 || userChoice > maxRange) {
            System.out.println("Incorrect choice. Try again with number between 1-" + maxRange);
            userChoice = UserInput.upLoadInt();
        }

        return userChoice;
    }

    public static void changeInSubcject(Subject subject) {
        int choice = MenuOption.uploadCorrectUserInput(MenuAppearance.subjectEditOptions.length);
        SubjectAccountEditor accountEditor = new SubjectAccountEditor();
        switch (choice) {
            case 1: {
                accountEditor.editSubjectName(subject);
                break;
            }
            case 2: {
                accountEditor.editSubjectTopic(subject);
                break;
            }
            case 3: {
                accountEditor.editSubjectRange(subject);
                break;
            }
            case 4: {
                accountEditor.editVideoLessonsPossibility(subject);
                break;

            }
        }
    }

}

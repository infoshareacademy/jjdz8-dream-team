package com.infoshareacademy.menu;


import com.infoshareacademy.calendar.CalendarService;
import com.infoshareacademy.subjects.SubjectService;
import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.users.TeacherService;

public class MenuOption {

    public static void chooseOptionMainMenu() {
        int userChoice = uploadCorrectUserInput(MenuAppearance.mainMenuOptions.length);
        TeacherService teacherService = new TeacherService();
        SubjectService subjectService = new SubjectService();
        CalendarService calendarService = new CalendarService();
        switch (userChoice) {
            case 1: {
                teacherService.createTeacherAccount();
                break;
            }
            case 2: {
                MenuAppearance.showDataEditMenu();
                chooseDataToEdit();
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
                calendarService.createTeacherTerms();
                break;
            }
            case 6: {
                MenuService menuService = new MenuService();
                menuService.exitApplication();
            }
        }
    }

    public static void chooseDataToEdit() {
        int userChoice = uploadCorrectUserInput(MenuAppearance.editMenuOptions.length);
        TeacherService service = new TeacherService();
        switch (userChoice) {
            case 1: {
                service.editTeacherNickName();
                break;
            }
            case 2: {
                service.editTeachersSubjectNAme();
                break;
            }
            case 3: {
                service.editTeachersSubjectRange();
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

package com.infoshareacademy.menu;


import com.infoshareacademy.subjects.SubjectService;
import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.users.TeacherService;
import com.infoshareacademy.users.Teachers;

public class MenuService {

    private static Integer userChoice;

    public static int uploadCorrectUserInput(int maxMenuRange) {
        System.out.println("Please choose what do you want to do");
        userChoice = UserInput.upLoadInt();
        while (userChoice < 1 || userChoice > maxMenuRange) {
            System.out.println("Incorrect choice. Try again with number between 1-4");
            userChoice = UserInput.upLoadInt();
        }

        return userChoice;
    }

    public static void chooseOptionMainMenu() {
        TeacherService teacherService = new TeacherService();
        SubjectService subjectService = new SubjectService();
        switch (userChoice) {
            case 1: {
                teacherService.createTeacherAccount();
            }
            case 2: {
                teacherService.editTeacherAccount();
            }
            case 3: {
                subjectService.searchSubject();
            }
            case 4: {
                teacherService.showBestRatedTeachers();
            }
        }
    }

    public static void chooseDataToEdit(Integer num, Teachers teachers) {
        TeacherService service = new TeacherService();
        switch (num) {
            case 1: {
                service.editTeacherNickName(teachers);
                break;
            }
            case 2: {
                service.editTeachersSubjectNAme(teachers);
                break;
            }
            case 3: {
                service.editTeachersSubjectRange(teachers);
                break;
            }
        }
    }

    public static void returnToMainMenu() {
        MainMenu.showMenu();
        MenuService.uploadCorrectUserInput();
        MenuService.chooseOptionMainMenu();
    }

}

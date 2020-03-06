package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.menu.MenuService;
import com.infoshareacademy.lectures.SubjectAccountCreator;
import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.userOutput.CommandPrinter;

import static com.infoshareacademy.fileOperations.FileNames.TEACHERS_JSON;

public class TeacherAccountCreator {

    public void createTeacherAccount() {
        Teacher teacher = createTeacher();
        decideToEnterSubject(teacher);
        savingTeacher(teacher);
    }

    private void savingTeacher(Teacher teacher) {
        Teachers teachers = JsonReader.create(new Teachers(), TEACHERS_JSON);
        teachers.addTeacher(teacher);
        JsonSaver.createJson(teachers, TEACHERS_JSON);
    }

    private Teacher createTeacher() {
        String teacherNickname = uploadCorrectTeacherNickname();
        Teacher teacher = new Teacher(teacherNickname);
        teacher.setPassword();

        return teacher;
    }

    private String uploadCorrectTeacherNickname() {
        CommandPrinter.enterNicknameHeader();
        String nickName = UserInput.uploadString();
        while (Teachers.teacherAlreadyExist(nickName)) {
            System.out.println("NickName already exist, please try again");
            nickName = UserInput.uploadString();
        }

        return nickName;
    }

    public void decideToEnterSubject(Teacher teacher) {
        CommandPrinter.doYouWantEnterSubjectHeader();
        String choice = UserInput.uploadString();
        while (true) {
            if (choice.equalsIgnoreCase("yes")) {
                addSubjectForTeacher(teacher);
                savingTeacher(teacher);
                return;
            }
            if (choice.equalsIgnoreCase("No")) {
                savingTeacher(teacher);
                returnToMainMenu();

                return;
            }

            System.out.println("please enter yes/no");
            choice = UserInput.uploadString();
        }
    }

    public void addSubjectForTeacher(Teacher teacher) {
        SubjectAccountCreator accountCreator = new SubjectAccountCreator();
        accountCreator.createSubjectsAccount(teacher);
        decideToEnterSubject(teacher);
    }

    private void returnToMainMenu() {
        CommandPrinter.accountSuccessfullySavedHeader();
        MenuService.returnToMainMenu();
    }
}

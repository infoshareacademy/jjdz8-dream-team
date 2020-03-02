package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.menu.MenuService;
import com.infoshareacademy.lectures.SubjectAccountCreator;
import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.userOutput.CommandPrinter;

import java.util.UUID;

public class TeacherAccountCreator {

    public void createTeacherAccount() {
        Teacher teacher = createTeacher();
        savingTeacher(teacher);
        decideToEnterSubject(teacher.getId());
    }

    private void savingTeacher(Teacher teacher) {
        Teachers teachers = JsonReader.create(new Teachers(), "users.json");
        teachers.addTeacher(teacher);
        JsonSaver.createJson(teachers, "users.json");
    }

    private Teacher createTeacher() {
        String teacherNickname = uploadCorrectTeacherNickname();
        Teacher teacher = new Teacher(teacherNickname);
        teacher.setPassword();

        return teacher;
    }

    private String uploadCorrectTeacherNickname() {
        CommandPrinter.enterNickname();
        String nickName = UserInput.uploadString();
        while (Teachers.teacherAlreadyExist(nickName)) {
            System.out.println("NickName already exist, please try again");
            nickName = UserInput.uploadString();
        }

        return nickName;
    }

    public void decideToEnterSubject(UUID teacherId) {
        CommandPrinter.doYouWantEnterSubject();
        String choice = UserInput.uploadString();
        while (true) {
            if (choice.equalsIgnoreCase("yes")) {
                addSubjectForTeacher(teacherId);

                return;
            }
            if (choice.equalsIgnoreCase("No")) {
                returnToMainMenu();

                return;
            }

            System.out.println("please enter yes/no");
            choice = UserInput.uploadString();
        }
    }

    public void addSubjectForTeacher(UUID teacherId) {
        SubjectAccountCreator accountCreator = new SubjectAccountCreator();
        accountCreator.createSubjectsAccount(teacherId);
        decideToEnterSubject(teacherId);
    }

    private void returnToMainMenu() {
        CommandPrinter.accountSuccesfullySaved();
        MenuService.returnToMainMenu();
    }
}

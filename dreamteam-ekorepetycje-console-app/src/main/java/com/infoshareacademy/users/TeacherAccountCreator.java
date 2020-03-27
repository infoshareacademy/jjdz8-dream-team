package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.menu.MenuService;
import com.infoshareacademy.lectures.SubjectAccountCreator;
import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.userOutput.CommandPrinter;

import static com.infoshareacademy.fileOperations.FileNames.TEACHERS_JSON;

public class TeacherAccountCreator implements AccountCreationCapable {

    private Teacher teacher;

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public void createAccount() {
        createUser();
        decideToEnterSubject();
        saveAccount();
    }

    public void saveAccount() {
        Teachers teachers = JsonReader.create(new Teachers(), TEACHERS_JSON);
        teachers.addTeacher(this.teacher);
        JsonSaver.createJson(teachers, TEACHERS_JSON);
    }

    public void createUser() {
        String teacherNickname = uploadCorrectTeacherNickname();
        this.teacher = new Teacher(teacherNickname);
        teacher.setPassword();
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

    public void decideToEnterSubject() {
        CommandPrinter.doYouWantEnterSubjectHeader();
        String choice = UserInput.uploadString();
        while (true) {
            if (choice.equalsIgnoreCase("yes")) {
                addSubjectForTeacher();
                return;
            }
            if (choice.equalsIgnoreCase("No")) {
                saveAccount();
                returnToMainMenu();

                return;
            }

            System.out.println("please enter yes/no");
            choice = UserInput.uploadString();
        }
    }

    public void addSubjectForTeacher() {
        SubjectAccountCreator accountCreator = new SubjectAccountCreator();
        accountCreator.createSubjectsAccount(this.teacher);
        decideToEnterSubject();
    }

    private void returnToMainMenu() {
        CommandPrinter.accountSuccessfullySavedHeader();
        MenuService.returnToMainMenu();
    }
}

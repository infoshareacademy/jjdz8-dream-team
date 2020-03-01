package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.menu.MenuService;
import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.userOutput.CommandPrinter;


public class TeacherAccountEditor {

    private TeacherAccount teacherAccount;

    public TeacherAccountEditor(TeacherAccount account) {
        this.teacherAccount = account;
    }

    public void editTeacherNickname() {
        String oldNickName = this.teacherAccount.getTeacher().getNickName();
        CommandPrinter.enterNewNickname();

        String newNickName = uploadCorrectNewNickname();
        setNewNickName(oldNickName, newNickName);

        CommandPrinter.yourNicknameWasChange();

        MenuService.returnToDataEditMenu(teacherAccount);
    }

    private void setNewNickName(String nickName, String newNickName) {
        Teachers teachers1 = JsonReader.create(new Teachers(), "users.json");
        for (Teacher teacher : teachers1.getTeachers()) {
            if (teacher.getNickName().equals(nickName)) {
                teacher.setNickName(newNickName);
            }
        }
        JsonSaver.createJson(teachers1, "users.json");
    }

    private String uploadCorrectNewNickname() {
        String newNickName = UserInput.uploadString();
        while (Teachers.teacherAlreadyExist(newNickName)) {
            System.out.println("Nickname: " + newNickName + "already exist please try again");
            newNickName = UserInput.uploadString();
        }

        return newNickName;
    }

    public void editTeacherPassword() {
        String teacherNickname = this.teacherAccount.getTeacher().getNickName();
        CommandPrinter.enterYourOldPassword();

        this.teacherAccount.acceptCorrectPassword(teacherNickname);
        setNewPassword(teacherNickname);

        CommandPrinter.yourPasswordSuccesfullyChanged();
        MenuService.returnToDataEditMenu(this.teacherAccount);

    }

    public void setNewPassword(String nickName) {
        Teachers teachers1 = JsonReader.create(new Teachers(), "users.json");
        for (Teacher teacher : teachers1.getTeachers()) {
            if (teacher.getNickName().equals(nickName)) {
                teacher.setPassword();
            }
        }
        JsonSaver.createJson(teachers1, "users.json");
    }

}

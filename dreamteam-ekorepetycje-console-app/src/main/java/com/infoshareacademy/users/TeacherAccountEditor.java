package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.menu.MenuService;
import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.userOutput.CommandPrinter;

import static com.infoshareacademy.fileOperations.FileNames.TEACHERS_JSON;

public class TeacherAccountEditor implements Editable {

    private TeacherAccount teacherAccount;

    public TeacherAccountEditor(TeacherAccount account) {
        this.teacherAccount = account;
    }

    public void editNickname() {
        String oldNickName = this.teacherAccount.getTeacher().getNickName();
        CommandPrinter.enterNewNicknameHeader();
        String newNickName = uploadCorrectNewNickname();
        setNewNickname(oldNickName, newNickName);
        CommandPrinter.yourNicknameWasChangeHeader();
        MenuService.returnToDataEditMenu(teacherAccount);
    }

    private void setNewNickname(String nickName, String newNickName) {
        Teachers teachers = JsonReader.create(new Teachers(), TEACHERS_JSON);
        teachers.findByNickname(nickName).setNickName(newNickName);
        JsonSaver.createJson(teachers, TEACHERS_JSON);
    }

    private String uploadCorrectNewNickname() {
        String newNickName = UserInput.uploadString();
        while (Teachers.teacherAlreadyExist(newNickName)) {
            System.out.println("Nickname: " + newNickName + "already exist please try again");
            newNickName = UserInput.uploadString();
        }

        return newNickName;
    }

    public void editPassword() {
        Teachers teachers = JsonReader.create(new Teachers(), TEACHERS_JSON);
        String teacherNickname = teachers.findById(this.teacherAccount.getTeacher().getId()).getNickName();
        CommandPrinter.enterYourOldPasswordHeader();
        this.teacherAccount.acceptCorrectPassword(teacherNickname);
        setNewPassword(teacherNickname);
        CommandPrinter.passwordChangedHeader();
        MenuService.returnToDataEditMenu(this.teacherAccount);
    }

    public void setNewPassword(String nickName) {
        Teachers teachers = JsonReader.create(new Teachers(), TEACHERS_JSON);
        teachers.findByNickname(nickName).setPassword();
        JsonSaver.createJson(teachers, TEACHERS_JSON);
    }
}

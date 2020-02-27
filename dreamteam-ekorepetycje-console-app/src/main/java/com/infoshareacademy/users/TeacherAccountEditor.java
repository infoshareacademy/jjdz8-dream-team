package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.menu.MenuAppearance;
import com.infoshareacademy.menu.MenuService;
import com.infoshareacademy.userInput.UserInput;

public class TeacherAccountEditor {

    private TeacherAccount teacherAccount;

    public TeacherAccountEditor (TeacherAccount account){
        this.teacherAccount = account;
    }

    public void editTeacherNickname(TeacherAccount account) {
        String oldNickName = account.getTeacher().getNickName();
        System.out.println("Please enter new NickName: ");
        String newNickName = uploadCorrectNewNickname();
        setNewNickName(oldNickName,newNickName);
        MenuService service = new MenuService();
        service.returnToMainMenu();
    }

    private void setNewNickName(String nickName, String newNickName){
        Teachers teachers1 = JsonReader.create(new Teachers(), "users.json");
        for (Teacher teacher : teachers1.getTeachers()) {
            if (teacher.getNickName().equals(nickName)) {
                teacher.setNickName(newNickName);
            }
        }
        JsonSaver.createJson(teachers1,"users.json");
    }

    private String  uploadCorrectNewNickname() {
        String newNickName = UserInput.uploadString();
        while (Teachers.teacherAlreadyExist(newNickName)){
            System.out.println("Nickname: "+ newNickName + "already exist please try again");
            newNickName = UserInput.uploadString();
        }

        return newNickName;
    }

    public void editTeacherPassword(TeacherAccount account) {
    }

    public void editTeachersSubjects(TeacherAccount account) {

    }

    public void addNewSubject(TeacherAccount account) {

    }
}

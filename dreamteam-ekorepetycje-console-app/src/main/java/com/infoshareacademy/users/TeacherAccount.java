package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.userInput.UserInput;

public class TeacherAccount {

    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public boolean logIn () {
        System.out.println("Please enter your nickNAme");
        String username = uploadCorrectAccount();
        System.out.println("Please enter your password");
        String password = UserInput.uploadString();
        while (!isPasswordCorrect(username,password)){
            System.out.println("Incorrect password, please try again");
            password = UserInput.uploadString();
        }

        this.teacher = new Teacher(username);
        System.out.println("Access Granted! Welcome!");

        return true;
    }

    public String  uploadCorrectAccount() {
        String nickName = UserInput.uploadString();
        while (!Teachers.teacherAlreadyExist(nickName)) {
            System.out.println("Incorrect nickName. Please try again ");
            nickName = UserInput.uploadString();
        }

        return nickName;
    }

    public boolean isPasswordCorrect (String userNAme, String password) {
        Teachers teachers = JsonReader.create(new Teachers(), "users.json");
        for (Teacher teacher : teachers.getTeachers()) {
            if (teacher.getPassword().equals(password)) {

                return true;
            }
        }

        return false;
    }



}

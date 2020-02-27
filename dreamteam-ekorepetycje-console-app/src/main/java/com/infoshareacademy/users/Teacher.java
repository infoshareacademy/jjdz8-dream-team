package com.infoshareacademy.users;

import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.userOutput.CommandPrinter;

import java.util.UUID;

public class Teacher {

    private String password;

    private UUID id;

    private String nickName;

    private double averageRating;

    public Teacher(String nickName) {
        this.id = UUID.randomUUID();
        this.nickName = nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        CommandPrinter.printPasswordRules();
        String password = UserInput.uploadString();
        while (!isCorrectPassword(password)) {
            System.out.println("Incorrect format, please try again");
            password = UserInput.uploadString();
        }
        this.password = password;

    }

    private boolean isCorrectPassword(String userPassword) {
        return userPassword.matches("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,10})");
    }

    public UUID getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

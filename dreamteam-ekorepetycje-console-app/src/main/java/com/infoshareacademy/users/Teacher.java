package com.infoshareacademy.users;

import com.infoshareacademy.userInput.UserInput;

import java.util.UUID;

public class Teacher {
    private String password;

    private UUID uuid;

    private String nickName;

    private double averageRating;

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        printPasswordRules();

        String password = UserInput.uploadString();
        while (!isCorrectPassword(password)){
            System.out.println("Incorrect format, please try again");
            password = UserInput.uploadString();
        }
        this.password = password;

    }
    private boolean isCorrectPassword(String password) {
        return password.matches("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,10})");
    }
    private void printPasswordRules (){
        System.out.println("Please enter new password: Be between 8 and 10 characters long\n" +
                "Contain at least one digit.\n" +
                "Contain at least one lower case character.\n" +
                "Contain at least one upper case character.\n" +
                "Contain at least on special character from [ @ # $ % ! . ].");
    }
    public void setUuid() {
        uuid = UUID.randomUUID();
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getNickName() {
        return nickName;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + uuid +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

package com.infoshareacademy.users;

import com.infoshareacademy.security.PasswordCoding;
import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.userOutput.CommandPrinter;

import java.util.UUID;

public class Teacher implements Comparable<Teacher> {

    private String password;

    private UUID id;

    private String nickName;

    private double averageRating;

    public Teacher(String nickName) {
        this.id = UUID.randomUUID();
        this.nickName = nickName;
    }

    public Teacher() {

    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        CommandPrinter.showPasswordRules();
        String password = UserInput.uploadString();
        while (!isCorrectPasswordFormat(password)) {
            System.out.println("Incorrect password format, please try again");
            password = UserInput.uploadString();
        }
        this.password = PasswordCoding.passwordHashing(password);
    }

    private boolean isCorrectPasswordFormat(String userPassword) {
        return userPassword.matches("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,20})");
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

    @Override
    public int compareTo(Teacher teacher) {
        if (averageRating > teacher.getAverageRating()) return 1;
        if (averageRating < teacher.getAverageRating()) return -1;
        return 0;
    }

}

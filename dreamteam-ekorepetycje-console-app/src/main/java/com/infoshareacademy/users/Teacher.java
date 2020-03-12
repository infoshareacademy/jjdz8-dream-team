package com.infoshareacademy.users;


public class Teacher extends User {

    private double averageRating;

    public Teacher(String nickName) {
        super(nickName);
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}

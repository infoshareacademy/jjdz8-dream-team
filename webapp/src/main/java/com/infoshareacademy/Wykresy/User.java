package com.infoshareacademy.Wykresy;

public class User {
    private String name;
    private double grade;

    // public User(String larry, double v) {
//}
        public User(){

        }

    public User(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}


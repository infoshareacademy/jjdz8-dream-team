package com.infoshareacademy.ratings;

public class Student {




    public Student(int id, int grade) {

    }

    public Student(double id, double grade) {

    }

    public Student(double grade, String s) {
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getGrade() {

        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private int id;
    private String subject;
    private int grade;
    private String comment;

    public double getSuma() {
        return getGrade();
    }

    private double suma;

    public Student(int id, String subject, int grade, String comment) {
        this.id = id;
        this.subject = subject;
        this.grade = grade;
        this.comment = comment;
    }



    //public Student(int id, String subject, int grade, String comment){}
    public Student() {
    }

    ;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", grade=" + grade +
                ", comment='" + comment + '\'' +
                '}';
    }


}


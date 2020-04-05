package com.infoshareacademy.ratings;

import java.util.UUID;

public class Grade {

    private UUID id;

    private UUID subjectId;

    private UUID teacherId;

    private double grade;

    private  String comment;

    public Grade(double grade){
        this.grade = grade;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(UUID subjectId) {
        this.subjectId = subjectId;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    public Double getGrade() {
        return grade;
    }

    public String getComment() {
        return comment;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
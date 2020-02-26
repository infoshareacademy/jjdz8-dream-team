package com.infoshareacademy.subjects;

import com.infoshareacademy.userInput.UserInput;

public class SubjectFactory {

    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void createSubject() {
        this.subject = new Subject();
        System.out.println("Enter subject name");
        this.subject.setName(UserInput.uploadString());
        this.subject.setUuid();

        System.out.println("Enter subject topic");
        this.subject.setTopic(UserInput.uploadString());

        System.out.println("Enter subject range, every phrase divide by /");
        this.subject.setRange(UserInput.uploadString().split("/"));

        System.out.println("Is video: enter true/false");
        boolean isVideo = Boolean.getBoolean(UserInput.uploadString());

    }
}

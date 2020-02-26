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

        System.out.println("Do you have video materials for this subject? enter yes/no");
        setIsVideo();

    }

    private void setIsVideo() {
        String choice = UserInput.uploadString();
        while (!choice.equalsIgnoreCase("yes") || !choice.equalsIgnoreCase("no")) {
            if (choice.equalsIgnoreCase("yes")) {
                this.subject.setVideo(true);

                return;
            }
            if (choice.equalsIgnoreCase("no")) {
                this.subject.setVideo(false);

                return;
            }

            System.out.println("Incorrect format please enter yes/no");
            choice = UserInput.uploadString();
        }
    }
}

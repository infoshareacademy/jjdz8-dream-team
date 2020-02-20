package com.infoshareacademy.subjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subjects {

    List<Subject> subjectsList;

    public Subjects(Subject...subjects) {
        this.subjectsList = Arrays.asList(subjects);
    }

    public void setSubject(Subject subject) {
        this.subjectsList.add(subject);
    }

    public List<Subject> getSubjects() {
        return subjectsList;
    }

    public void addSubject(Subject... subjects) {
        if (subjectsList.size() == 0){
            subjectsList = new ArrayList<>();
        }
        for (Subject subject:subjects) {
            subjectsList.add(subject);
        }
    }

    public void printSubjects() {
        for (Subject subject : this.subjectsList) {
            System.out.println(subject);
        }
    }

    public Subject getSubjectByName(String name, Subjects subjects) {
        for (Subject subject: subjects.getSubjects()) {
            if (subject.getName().equals(name)) {
                return subject;
            }
        }

        return null;
    }


}

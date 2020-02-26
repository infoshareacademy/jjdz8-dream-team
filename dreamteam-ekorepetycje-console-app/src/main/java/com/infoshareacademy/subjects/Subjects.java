package com.infoshareacademy.subjects;

import java.util.ArrayList;
import java.util.List;

public class Subjects {

    private List<Subject> subjectsList = new ArrayList<>();

    public void addSubject(Subject... subjects) {
        for (Subject subject : subjects) {
            this.subjectsList.add(subject);
        }
    }

    public List<Subject> getSubjectsList() {
        return subjectsList;
    }
}

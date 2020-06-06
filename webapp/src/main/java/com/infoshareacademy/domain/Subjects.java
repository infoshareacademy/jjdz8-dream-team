package com.infoshareacademy.domain;

import java.util.ArrayList;
import java.util.List;

public class Subjects {

    private List<Subject> subjectsList = new ArrayList<>();

    public List<Subject> getSubjects() {
        return this.subjectsList;
    }

    public void addSubject(Subject subject) {
        this.subjectsList.add(subject);
    }

    public void deleteSubject(Subject subject){
        for (int i =0; i< this.subjectsList.size(); i++){
            if (this.subjectsList.get(i).getId().equals(subject.getId())) this.subjectsList.remove(i);
        }
    }
}

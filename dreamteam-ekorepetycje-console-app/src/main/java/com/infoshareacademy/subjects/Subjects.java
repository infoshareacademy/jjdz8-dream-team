package com.infoshareacademy.subjects;

import java.util.ArrayList;
import java.util.List;

public class Subjects {

    List<Subject> subjectsList;

    public void addSubject(Subject... subjects) {
        if (subjectsList.size() == 0) {
            subjectsList = new ArrayList<>();
        }
        for (Subject subject : subjects) {
            subjectsList.add(subject);
        }
    }

}

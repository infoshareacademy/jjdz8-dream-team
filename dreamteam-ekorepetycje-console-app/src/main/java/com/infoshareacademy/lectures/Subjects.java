package com.infoshareacademy.lectures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subjects {

    private List<Subject> subjectsList = new ArrayList<>();

    public void addSubject(Subject... subjects) {
        this.subjectsList.addAll(Arrays.asList(subjects));
    }

    public List<Subject> getSubjectsList() {
        return subjectsList;
    }
}

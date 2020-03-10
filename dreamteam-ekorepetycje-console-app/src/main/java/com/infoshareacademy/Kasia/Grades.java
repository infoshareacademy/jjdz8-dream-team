package com.infoshareacademy.Kasia;

import com.infoshareacademy.lectures.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grades {

    List<Grade> gradeList = new ArrayList<>();

    public void addGrade(Grade... grades) {
        this.gradeList.addAll(Arrays.asList(grades));
    }

    public List<Grade> getGradeList() {
        return this.gradeList;
    }
}

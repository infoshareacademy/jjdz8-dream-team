package com.infoshareacademy.ratings;

import com.infoshareacademy.users.Teacher;

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

    public List<Double> findGradesForTeacher(Teacher teacher){
        List<Double> oneTeacherGrades = new ArrayList<>();
        for (Grade grade: gradeList) {
            if (grade.getTeacherId().equals(teacher.getId())) {
                oneTeacherGrades.add(grade.getGrade());
            }
        }
        return oneTeacherGrades;
    }

    public List<String> findAllCommentForTeacher(Teacher teacher){
        List<String> allComments = new ArrayList<>();
        for (Grade grade: gradeList) {
            if (grade.getTeacherId().equals(teacher.getId())) {
                allComments.add(grade.getComment() +" grade : " + grade.getGrade());
            }
        }

        return allComments;
    }

    public void printComments(List<String>  comments){
        System.out.println("***************************************************************");
        System.out.println("All Teacher Comments");
        System.out.println("***************************************************************");
        for (int i = 0; i< comments.size(); i++){
            System.out.println((i+1)+ ". " + comments.get(i));
        }
        System.out.println("***************************************************************");

    }
}

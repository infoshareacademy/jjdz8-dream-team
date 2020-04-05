package com.infoshareacademy.dataSorter;


import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.ratings.Grades;
import com.infoshareacademy.users.Teacher;
import com.infoshareacademy.users.Teachers;
import com.infoshareacademy.operation.Calculator;

import java.util.Collections;
import java.util.List;

public class TeachersSorter {

    Teachers teachers = JsonReader.create(new Teachers(), FileNames.TEACHERS_JSON);

    Grades grades = JsonReader.create(new Grades(), FileNames.GRADES_JSON);

    public void printTeacherRanking() {
        sortTeachersByAverageRating();
        int count = 1;
        for (Teacher teacher : teachers.getTeachers()) {
            if (teacher.getAverageRating() == 0.0) {
                System.out.println(count + ". " + teacher.getNickName() + "* This Teacher already dont have any grade");
                count++;
                continue;
            }
            List<Double> teacherGrades = grades.findGradesForTeacher(teacher);
            System.out.println(count + ". " + teacher.getNickName() + "*  average rating: " + Calculator.roundToTwoDecimals(teacher.getAverageRating())
                    + "  from " + teacherGrades.size() + "   grades entered by students");
            count++;
        }
    }

    private void sortTeachersByAverageRating() {
        Collections.sort(teachers.getTeachers());
    }

}
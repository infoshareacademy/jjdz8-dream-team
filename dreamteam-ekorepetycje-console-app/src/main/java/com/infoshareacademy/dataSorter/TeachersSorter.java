package com.infoshareacademy.dataSorter;


import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.ratings.Grades;
import com.infoshareacademy.users.Teacher;
import com.infoshareacademy.users.TeacherService;
import com.infoshareacademy.users.Teachers;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

public class  TeachersSorter {
    Teachers teachers = JsonReader.create(new Teachers(), FileNames.TEACHERS_JSON);
    Grades grades = JsonReader.create(new Grades(), FileNames.GRADES_JSON);

    public void printTeacherRanking() {
       TeacherService teacherService = new TeacherService();
        teacherService.showTeacherRanking();
        teacherService.sortTeachersByAverageRating();

        }
    public String roundToTwoDecimals(double number) {
        DecimalFormat f = new DecimalFormat("##.00");
        return f.format(number);
    }
}
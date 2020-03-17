package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.menu.MenuAppearance;
import com.infoshareacademy.menu.MenuOption;
import com.infoshareacademy.ratings.Grades;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

public class TeacherService {

    public void createTeacherAccount() {
        TeacherAccountCreator account = new TeacherAccountCreator();
        account.createAccount();
    }

    public void editTeacherAccount() {
        TeacherAccount account = new TeacherAccount();
        if (account.logIn()) {
            MenuAppearance.showDataEditMenu();
            MenuOption.chooseDataToEdit(account);
        }
    }

    Teachers teachers = JsonReader.create(new Teachers(), FileNames.TEACHERS_JSON);
    Grades grades = JsonReader.create(new Grades(), FileNames.GRADES_JSON);

    public void showTeacherRanking() {
        sortTeachersByAverageRating();
        int count = 1;
        for (Teacher teacher : teachers.getTeachers()) {
            if (teacher.getAverageRating() == 0.0) {
                System.out.println(count + ". " + teacher.getNickName() + "* This Teacher already dont have any grade");
                count++;
                continue;
            }
            List<Double> teacherGrades = grades.findGradesForTeacher(teacher);
            System.out.println(count + ". " + teacher.getNickName() + "*  average rating: " + roundToTwoDecimals(teacher.getAverageRating())
                    + "  from " + teacherGrades.size() + "   grades entered by students");
            count++;
        }
    }

    public void sortTeachersByAverageRating() {
        Collections.sort(teachers.getTeachers());
    }

    public String roundToTwoDecimals(double number) {
        DecimalFormat f = new DecimalFormat("##.00");
        return f.format(number);
    }

}



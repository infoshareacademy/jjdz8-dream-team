//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.infoshareacademy.calendar;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.users.Teacher;
import com.infoshareacademy.users.TeacherTerm;
import com.infoshareacademy.users.TeacherTerms;
import com.infoshareacademy.users.Teachers;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.UUID;

public class CalendarService {
    public CalendarService() {
    }

    public void createTeacherTerms() {
        TeacherTerms teacherTerms = new TeacherTerms();
        Iterator var2 = teacherTerms.getTeacherTerms().iterator();

        while(var2.hasNext()) {
            TeacherTerm teacherTerm = (TeacherTerm)var2.next();
            this.addingTeacherID(teacherTerm);
            this.savingTeacherTerms(teacherTerm);
            this.displayTeacherTerms(teacherTerm);
        }

    }

    public void addingTeacherID(TeacherTerm teacherTerm) {
        Teachers teachers = (Teachers)JsonReader.create(new Teachers(), "users.json");
        Iterator var3 = teachers.getTeachers().iterator();

        while(var3.hasNext()) {
            Teacher teacher = (Teacher)var3.next();
            if (teacher.getNickName().equals(teacherTerm.getNickName())) {
                teacherTerm.setTeacherId(teacher.getId());
            } else {
                teacherTerm.setTeacherId(UUID.randomUUID());
            }

            PrintStream var10000 = System.out;
            String var10001 = teacher.getNickName();
            var10000.println("Nickname from teachers: " + var10001 + ", ID from teacher: " + teacher.getId());
        }

    }

    private void savingTeacherTerms(TeacherTerm teacherTerm) {
        TeacherTerms teacherTerms = new TeacherTerms();
        teacherTerms.addTeacherTerm(new TeacherTerm[]{teacherTerm});
        JsonSaver.createJson(teacherTerms, "terms.json");
    }

    public void displayTeacherTerms(TeacherTerm teacherTerm) {
        System.out.println(teacherTerm.toString());
    }
}

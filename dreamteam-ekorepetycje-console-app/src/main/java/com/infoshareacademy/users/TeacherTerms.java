//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.calendar.CalendarTermsReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TeacherTerms {
    private List<TeacherTerm> teacherTerms = new ArrayList();

    public TeacherTerms() {
        CalendarTermsReader calendarTermsReader = new CalendarTermsReader();
        this.teacherTerms = calendarTermsReader.getTeacherCalendars();
    }

    public void addTeacherTerm(TeacherTerm... teacherTerms) {
        this.teacherTerms.addAll(Arrays.asList(teacherTerms));
    }

    public List<TeacherTerm> getTeacherTerms() {
        return this.teacherTerms;
    }

    public static boolean teacherTermsAlreadyExist(String nickName) {
        TeacherTerms teacherTerms = JsonReader.create(new TeacherTerms(), "terms.json");
        Iterator var2 = teacherTerms.getTeacherTerms().iterator();

        TeacherTerm teacherTerm;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            teacherTerm = (TeacherTerm)var2.next();
        } while(!teacherTerm.getNickName().equals(nickName));

        System.out.println("Calendar already exist, please try again");
        return true;
    }
}

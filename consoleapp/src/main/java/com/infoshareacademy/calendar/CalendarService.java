//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.infoshareacademy.calendar;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.lectures.Subject;
import com.infoshareacademy.menu.MenuAppearance;
import com.infoshareacademy.menu.MenuOption;
import com.infoshareacademy.userOutput.CommandPrinter;
import com.infoshareacademy.users.*;

import net.fortuna.ical4j.model.DateTime;
import org.apache.commons.collections4.ArrayStack;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.*;

public class CalendarService {

    public void calendarOptions() {
        MenuAppearance.showTermsMenu();
    }

    public void showAllTermsOfSpecificTeacher() {
        CommandPrinter.chooseTeacher();
        CalendarService calendarService = new CalendarService();
        calendarService.displayTeachers(calendarService.createTeacherTerms());
        MenuAppearance.showTermsMenu();
        MenuOption.chooseCalendarOptions();
    }

    public void showAllOneTermsOfSpecificSubject() {
        CommandPrinter.enterSubject();
        CalendarService calendarService = new CalendarService();
        calendarService.displaySubjects(calendarService.createTeacherTerms());
        MenuAppearance.showTermsMenu();
        MenuOption.chooseCalendarOptions();
    }

    public void showAllTerms() {
        CalendarService calendarService = new CalendarService();
        displayAllTeacherTerms(calendarService.createTeacherTerms());
        MenuAppearance.showTermsMenu();
        MenuOption.chooseCalendarOptions();
    }

    public TeacherTerms createTeacherTerms() {
        TeacherTerms teacherTerms = new TeacherTerms();
        Iterator var2 = teacherTerms.getTeacherTerms().iterator();

        while(var2.hasNext()) {
            TeacherTerm teacherTerm = (TeacherTerm)var2.next();
            this.addingTeacherID(teacherTerm);
            this.savingTeacherTerms(teacherTerm);
        }
        return teacherTerms;
    }

    public void addingTeacherID(TeacherTerm teacherTerm) {
        Teachers teachers = JsonReader.create(new Teachers(), "users.json");
        Iterator var3 = teachers.getTeachers().iterator();

        while(var3.hasNext()) {
            Teacher teacher = (Teacher)var3.next();
            if (teacher.getNickName().equals(teacherTerm.getNickName())) {
                teacherTerm.setTeacherId(teacher.getId());
            } else {
                teacherTerm.setTeacherId(UUID.randomUUID());
            }
        }
    }

    private void savingTeacherTerms(TeacherTerm teacherTerm) {
        TeacherTerms teacherTerms = new TeacherTerms();
        teacherTerms.addTeacherTerm(teacherTerm);
        JsonSaver.createJson(teacherTerms, "terms.json");
    }

    public void displayAllTeacherTerms(TeacherTerms teacherTerms) {
        //TeacherTerms teacherTerms = new TeacherTerms();
        Iterator var4 = teacherTerms.getTeacherTerms().iterator();

        while(var4.hasNext()) {
            TeacherTerm teacherTerm = (TeacherTerm) var4.next();
            System.out.println(teacherTerm.toString());
        }
    }

    public void displayTeachers(TeacherTerms teacherTerms) {
        Iterator var5 = teacherTerms.getTeacherTerms().iterator();
        int i = 1;
        while(var5.hasNext()) {
            TeacherTerm teacherTerm = (TeacherTerm) var5.next();
            System.out.print(i++ + ". ");
            System.out.println(teacherTerm.getNickName());
        }
        int num = MenuOption.uploadCorrectUserInput(teacherTerms.getTeacherTerms().size());
        int choice = num - 1;
        for (int j = 0; j < teacherTerms.getTeacherTerms().size(); j++) {
            if (j == choice) {
                System.out.println(teacherTerms.getTeacherTerms().get(j));
            }
        }
    }

    public void displaySubjects(TeacherTerms teacherTerms) {
        Iterator var5 = teacherTerms.getTeacherTerms().iterator();
        Set<String> subjectsSet = new HashSet<>();

        while(var5.hasNext()) {
            TeacherTerm teacherTerm = (TeacherTerm) var5.next();
            for (Map.Entry<LocalDate, String> term : teacherTerm.getTerms().entrySet()) {
                subjectsSet.add(term.getValue());
            }
        }
            int i = 1;
            int j = 0;
            String[] subjectsTable = new String[subjectsSet.size()];
            for (String subject:subjectsSet) {
                subjectsTable[j] = subject;
                System.out.println(i + ". " + subject);
                i++;
                j++;
            }

            int num = MenuOption.uploadCorrectUserInput(subjectsTable.length);
            int choice = num - 1;
            String subjectName = "";
            for (j = 0; j < subjectsTable.length; j++) {
                if (j == choice) {
                    subjectName = subjectsTable[j];
                }
            }
        Iterator var6 = teacherTerms.getTeacherTerms().iterator();
        while(var6.hasNext()) {
            TeacherTerm teacherTerm = (TeacherTerm) var6.next();
            for(Map.Entry<LocalDate, String> term : teacherTerm.getTerms().entrySet()) {
                if (subjectName.equals(term.getValue())) {
                    System.out.println(teacherTerm.getNickName() + ": " + term.getKey() + " ");
                }
            }
        }
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.infoshareacademy.calendar;

import com.infoshareacademy.users.TeacherTerm;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;

public class CalendarTermsReader {
    private List<TeacherTerm> teacherTerms = new ArrayList();

  //  public CalendarTermsReader() {
  //  }

    public List<TeacherTerm> getTeacherCalendars() {
        CalendarFileReader calendarFileReader = new CalendarFileReader();
        File[] listOfFiles = this.getElementsInDir("calendars");
        File[] var3 = listOfFiles;
        int var4 = listOfFiles.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            File f = var3[var5];
            String teacherNickName = f.getName().substring(0, f.getName().lastIndexOf(46));
            TeacherTerm teacherTerm = new TeacherTerm(teacherNickName);
            teacherTerm.setNickName(teacherNickName);
            Calendar calendar = calendarFileReader.readCalendar(f);
            List<Component> vevents = calendar.getComponents("VEVENT");
            Iterator var11 = vevents.iterator();

            while(var11.hasNext()) {
                Component event = (Component)var11.next();
                String dtStart = event.getProperty("DTSTART").getValue();
                String subject = event.getProperty("SUMMARY").getValue();
                LocalDate term = this.getDateTimeFromICalParam(dtStart);
                teacherTerm.addTerm(term, subject);
            }

            this.teacherTerms.add(teacherTerm);
        }

        return this.teacherTerms;
    }

    private File[] getElementsInDir(String resource) throws NullPointerException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        String elementsPath = classLoader.getResource(resource).getPath();
        File elementsDir = new File(elementsPath);
        return elementsDir.listFiles();
    }

    private LocalDate getDateTimeFromICalParam(String dtstamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        try {
            return LocalDate.parse(dtstamp, formatter);
        } catch (DateTimeParseException var4) {
            formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss");
            return LocalDate.parse(dtstamp, formatter);
        }
    }
}

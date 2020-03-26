package com.infoshareacademy.calendar;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

public class CalendarFileReader {

    public Calendar readCalendar(File icsFile) {

        try {
            FileInputStream fin = new FileInputStream(icsFile);
            CalendarBuilder builder = new CalendarBuilder();
            Calendar calendar = builder.build(fin);
            return calendar;
        } catch (IOException | ParserException e) {
            System.out.println(e);
        }
        return null;
    }

}

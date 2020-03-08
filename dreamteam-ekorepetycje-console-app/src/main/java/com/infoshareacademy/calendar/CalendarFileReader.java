package com.infoshareacademy.calendar;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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

package com.infoshareacademy.Kasia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

    public class GsonExample {
        public void studentWithGradesExample() {

            Students students = new Students();
            Student student = new Student("Kasia");
            student.addGrade(2.6);
            student.addGrade(4.0);
            student.addGrade(3.5);
            student.addGrade(4.9);
            student.addGrade(4.6);
            student.addGrade(4.6);
            student.addGrade(4.6);
            student.addGrade(5.0);

            students.addStudent(student);
            createJson(students, "studenci2.json");

        }

        public static <T> void createJson(T object, String filename) {
            try (Writer writer = new FileWriter(filename)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(object, writer);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }}}


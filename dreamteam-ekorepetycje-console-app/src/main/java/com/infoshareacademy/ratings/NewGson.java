package com.infoshareacademy.ratings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NewGson {


    public static <T> T createReader2(String t, String fileName) {
        if (doNotExistAlready(fileName)) {
            return (T) t;
        } else {
            Gson gson = new Gson();
            try {
                t = gson.fromJson(new FileReader(fileName), (Type) t.getClass());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (T) t;
    }
        public static <T> T createReader(T object, String fileName) {
            if (doNotExistAlready(fileName)) {
                return object;
            } else {
                Gson gson = new Gson();
                try {
                    object = gson.fromJson(new FileReader(fileName), (Type) object.getClass());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return object;
        }

        public static boolean doNotExistAlready(String fileName) {
            File file = new File(fileName);

            return !file.exists() || file.length() == 0;
        }

    public static <T> void createJson(T object, String filename) {
        try (Writer writer = new FileWriter(filename)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(object, writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }}



    public void GsonMethod(Student student10) throws IOException {
            // Converts a collection of string object into JSON string.
            List<String> names = new ArrayList<String>();

            names.add("Alice");
            names.add("Bob");
            names.add("Carol");
            names.add("Mallory");

            Gson gson = new Gson();
            String jsonNames = gson.toJson(names);
            System.out.println("jsonNames = " + jsonNames);



            // Converts a collection Student object into JSON string
            Student a = new Student(1,"matematyka",4,"super");
            Student b = new Student(2, "fizyka", 3,"zle");
            Student c = new Student(1,"polski",6,"w porzadku");
            Student d =new Student (1,"biologia",5,"niezle");

            List<Student> students = new ArrayList<Student>();
            students.add(a);
            students.add(b);
            students.add(c);
          students.add(d);


            gson = new Gson();
            String jsonStudents = gson.toJson(students);
            System.out.println("jsonStudents = " + jsonStudents);

            // Converts JSON string into a collection of Student object.
            Type type = new TypeToken<List<Student>>() {}.getType();
            List<Student> studentList = gson.fromJson(jsonStudents, type);
            createJson(studentList,"json6.json");

            createReader(studentList,"json6.json");

        for (Student student:studentList) {


                if(student.getId()==1) {
                    System.out.println("ocena nauczyciela o id =1"+" "+student.getGrade());
                    List<Double> suma=new ArrayList<>();


                    suma.add(a.getGrade());
                    suma.add(b.getGrade());
                    suma.add(c.getGrade());

                    createJson(suma,"jason62.json" ); }

            }


                }}





















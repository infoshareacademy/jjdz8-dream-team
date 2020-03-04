package com.infoshareacademy.ratings;

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
        students.addStudent(student);
        createJson(students, "studenci.json");

    }

        public void StataRederJson(){
            Students studentsFromFile=createReader(new Students(),"studenci.json");
            for(Student s:studentsFromFile.getStudents()){
                if (s.getName().equals("Kasia")) {
                    ArrayList<Double> grades = s.getGrades();
                    GsonExample gson4=new GsonExample();
                    for (int i = 0; i <grades.size() ; i++) {
                        double a=grades.get(i);


                        System.out.println(grades.toArray());}
                    System.out.println("*************");
                    System.out.println("Oceny studenta Kasia" + grades);}
                else {
                    System.out.println("Nie znaleziono studenta o imieniu Kasia");


                }}}    public void WriteToFile(String strContent) {

        BufferedWriter bufferedWriter = null;
        try {

            File myFile = new File("MyTestFile2.txt");

            if (!myFile.exists()) {
                myFile.createNewFile();
            }
            Writer writer = new FileWriter(myFile);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(strContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(bufferedWriter != null) bufferedWriter.close();
            } catch(Exception ex){

            }
        }}

    public double SimpleReader(String line){
        try {
            FileReader reader = new FileReader("MyTestFile.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);



            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
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
        }}}




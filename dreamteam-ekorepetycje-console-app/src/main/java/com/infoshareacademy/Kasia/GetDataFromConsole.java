package com.infoshareacademy.Kasia;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.lectures.Subject;
import com.infoshareacademy.lectures.SubjectAccountEditor;
import com.infoshareacademy.lectures.Subjects;
import com.infoshareacademy.users.Teacher;
import com.infoshareacademy.users.TeacherAccount;
import com.infoshareacademy.users.Teachers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Scanner;


public class GetDataFromConsole {

    public void GetData(){

        Scanner scan = new Scanner(System.in);
        boolean output=true;
        while (output) {


            System.out.println("List all teachers in e-korepetycje service:");
            Teachers teachers = JsonReader.create(new Teachers(),FileNames.TEACHERS_JSON);
            teachers.printTeacherList();
            System.out.println("Enter teacherNickname");
            TeacherAccount account = new TeacherAccount();
            String nickName = account.uploadCorrectNickname();
            System.out.println("All teacher's subjects: ");
            Teacher teacher = teachers.findByNickname(nickName);
            Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);
            List<Subject> oneTeacherSubjects = subjects.findSubjectsForOneTeacher(teacher.getId());
            subjects.printSubjectsList(oneTeacherSubjects);
            System.out.println("Which subject do you want assess? Please enter number from 1 - " +oneTeacherSubjects.size());
            SubjectAccountEditor subjectAccountEditor = new SubjectAccountEditor();
            Subject subject = subjectAccountEditor.uploadCorrectSubject(oneTeacherSubjects);
            System.out.println("Podaj ocene- zakres od 2 do 6");
            double gradeForTeacher = scan.nextDouble();
            System.out.println("podaj komentarz");
            String comment = scan.nextLine();

            Grade grade = new Grade(gradeForTeacher);
            grade.setSubjectId(subject.getId());
            grade.setTeacherId(teacher.getId());
            grade.setComment(comment);
            Grades grades = JsonReader.create(new Grades(),FileNames.GRADES_JSON);
            grades.addGrade(grade);
            JsonSaver.createJson(grades, FileNames.GRADES_JSON);
            System.out.println("Czy chcesz podać następną ocenę [y/n] ");

            Scanner answer = new Scanner(System.in);
            String s = answer.next();
            answer.nextLine();
            if (s.trim().toLowerCase().equals("y")) {

                output = true;
            }
            else if (s.trim().toLowerCase().equals("n")) {
                output = false;
            }}}


    public static <T> void createJson(T object, String filename) {
        try (Writer writer = new FileWriter(filename)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(object, writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


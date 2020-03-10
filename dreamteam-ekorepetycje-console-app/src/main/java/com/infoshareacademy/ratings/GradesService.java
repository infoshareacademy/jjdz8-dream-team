package com.infoshareacademy.ratings;

import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.lectures.Subject;
import com.infoshareacademy.lectures.SubjectAccountEditor;
import com.infoshareacademy.lectures.Subjects;
import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.users.Teacher;
import com.infoshareacademy.users.TeacherAccount;
import com.infoshareacademy.users.Teachers;

import java.util.List;
import java.util.Scanner;

public class GradesService {

    private Teacher teacher;

    private Grades grades;

    private Teachers teachers = JsonReader.create(new Teachers(), FileNames.TEACHERS_JSON);

    public void setAGradeToTheTeacher() {
        boolean output=true;
        while (output) {

            System.out.println("List all teachers in e-korepetycje service:");
            this.teachers.printTeacherList();

            System.out.println("Enter teacherNickname");
            TeacherAccount account = new TeacherAccount();
            String nickName = account.uploadCorrectNickname();

            System.out.println("All teacher's subjects: ");
            this.teacher = teachers.findByNickname(nickName);
            Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);
            List<Subject> oneTeacherSubjects = subjects.findSubjectsForOneTeacher(teacher.getId());
            subjects.printSubjectsList(oneTeacherSubjects);

            System.out.println("Which subject do you want assess? Please enter number from 1 - " +oneTeacherSubjects.size());
            SubjectAccountEditor subjectAccountEditor = new SubjectAccountEditor();
            Subject subject = subjectAccountEditor.uploadCorrectSubject(oneTeacherSubjects);

            System.out.println("Podaj ocene- zakres od 2 do 6");
            double gradeForTeacher = UserInput.upLoadDouble();

            System.out.println("podaj komentarz");
            String comment = UserInput.uploadString();

            Grade grade = new Grade(gradeForTeacher);
            grade.setSubjectId(subject.getId());
            grade.setTeacherId(teacher.getId());
            grade.setComment(comment);

            this.grades = JsonReader.create(new Grades(),FileNames.GRADES_JSON);
            this.grades.addGrade(grade);
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
            }
        }

            StandardDeviation standard= new StandardDeviation();
            try {
                standard.StataRederJson(this.teachers.findById(this.teacher.getId()));
            } catch (Exception e) {
                e.printStackTrace();

        }

        JsonSaver.createJson(this.teachers, FileNames.TEACHERS_JSON);

        this.grades.printComments(this.grades.findAllCommentForTeacher(this.teacher));
    }



}

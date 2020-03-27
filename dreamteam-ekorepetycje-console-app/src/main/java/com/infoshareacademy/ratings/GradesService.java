package com.infoshareacademy.ratings;

import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.lectures.Subject;
import com.infoshareacademy.lectures.SubjectAccountEditor;
import com.infoshareacademy.lectures.Subjects;
import com.infoshareacademy.menu.MenuService;
import com.infoshareacademy.userInput.UserInput;
import com.infoshareacademy.users.Teacher;
import com.infoshareacademy.users.TeacherAccount;
import com.infoshareacademy.users.Teachers;

import java.util.List;

public class GradesService {

    private Teacher teacher;

    private Grades grades;

    private Grade grade;

    private Teachers teachers = JsonReader.create(new Teachers(), FileNames.TEACHERS_JSON);

    private List<Subject> oneTeacherSubjects;

    private Subject subject;

    public void setAGradeToTheTeacher() {
        showAllTeacherToAssess();
        String nickName = uploadCorrectAssesingTeacherNickname();
        showAllTeachersSubjects(nickName);
        chooseSubjectToAsses();
        double gradeForTeacher = enterGrade();
        String comment = enterComment();
        createGrade(gradeForTeacher, comment);
        saveGrade();
        calculateStandardDeviation();
        JsonSaver.createJson(this.teachers, FileNames.TEACHERS_JSON);
        this.grades.printComments(this.grades.findAllCommentForTeacher(this.teacher), this.subject);
        decideToEnterAnotherGrade();
    }

    private void decideToEnterAnotherGrade() {
        System.out.println("Czy chcesz podać następną ocenę [y/n] ");
        String choice = UserInput.uploadString();
        while (true) {
            if (choice.equalsIgnoreCase("y")) {
                setAGradeToTheTeacher();
                return;
            }
            if (choice.equalsIgnoreCase("n")) {
                MenuService.returnToMainMenu();
                return;
            }
            System.out.println("please enter yes/no");
            choice = UserInput.uploadString();
        }
    }

    private void calculateStandardDeviation() {
        StandardDeviation standard = new StandardDeviation();
        try {
            if (this.teachers.findById(this.teacher.getId()).isPresent()) {
                standard.StataRederJson(this.teachers.findById(this.teacher.getId()).get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAllTeacherToAssess() {
        System.out.println("List all teachers in e-korepetycje service:");
        this.teachers.printTeacherList();
    }

    private String uploadCorrectAssesingTeacherNickname() {
        System.out.println("Enter teacherNickname");
        TeacherAccount account = new TeacherAccount();

        return account.uploadCorrectNickname();
    }

    private void showAllTeachersSubjects(String nickName) {
        System.out.println("All teacher's subjects: ");
        if (teachers.findByNickname(nickName).isPresent()) {
            this.teacher = teachers.findByNickname(nickName).get();

            Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);
            this.oneTeacherSubjects = subjects.findSubjectsForOneTeacher(teacher.getId());
            subjects.printSubjectsList(this.oneTeacherSubjects);
        }
    }

    private void chooseSubjectToAsses() {
        System.out.println("Which subject do you want assess? Please enter number from 1 - " + oneTeacherSubjects.size());
        SubjectAccountEditor subjectAccountEditor = new SubjectAccountEditor();
        this.subject = subjectAccountEditor.uploadCorrectSubject(oneTeacherSubjects);

    }

    private double enterGrade() {
        System.out.println("Podaj ocene- zakres od 2 do 6");
        return UserInput.upLoadDouble(2, 6);
    }

    private String enterComment() {
        System.out.println("podaj komentarz");
        return UserInput.uploadString();
    }

    private void createGrade(Double gradeForTeacher, String comment) {
        this.grade = new Grade(gradeForTeacher);
        grade.setSubjectId(this.subject.getId());
        grade.setTeacherId(this.teacher.getId());
        grade.setComment(comment);
    }

    private void saveGrade() {
        this.grades = JsonReader.create(new Grades(), FileNames.GRADES_JSON);
        this.grades.addGrade(grade);
        JsonSaver.createJson(grades, FileNames.GRADES_JSON);
    }

}

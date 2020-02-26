package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.menu.MenuService;
import com.infoshareacademy.subjects.Subject;
import com.infoshareacademy.subjects.Subjects;
import com.infoshareacademy.userInput.UserInput;

import java.util.UUID;

public class TeacherAccountCreator {


    public Teacher createTeacherAccount() {
        Teachers teachers = JsonReader.create(new Teachers(), "users.json");
        Teacher teacher = createTeacher();

        teachers.addTeacher(teacher);
        JsonSaver.createJson(teachers, "users.json");

        decideToEnterSubject(teacher.getUuid());

        return teacher;
    }

    public void decideToEnterSubject(UUID teacherId) {
        System.out.println("Do you want enter subject? Yes/No");
        String choice = UserInput.uploadString();
        while (true) {
            if (choice.equalsIgnoreCase("yes")) {
                createSubjectsAccount(teacherId);
                decideToEnterSubject(teacherId);
                break;
            }
            if (choice.equalsIgnoreCase("No")) {
                System.out.println("Your account was safely saved!!");
                MenuService service = new MenuService();
                service.returnToMainMenu();
                break;

            } else {
                System.out.println("please enter yes/no");
                choice = UserInput.uploadString();
            }
        }
    }

    private Teacher createTeacher() {
        String nickName = "";
        System.out.println("Enter Nickname");
        do {
            nickName = UserInput.uploadString();
        } while (Teachers.teacherAlreadyExist(nickName));

        TeacherFactory teacherFactory = new TeacherFactory();
        return teacherFactory.make(nickName);
    }

    public void createSubjectsAccount(UUID teacherID) {
        Subjects subjects = JsonReader.create(new Subjects(), "subjects.json");
        Subject subject = createSubject();
        subject.setTeacherId(teacherID);
        subjects.addSubject(subject);
        JsonSaver.createJson(subjects, "subjects.json");
    }

    private Subject createSubject() {
        Subject subject = new Subject();
        System.out.println("Enter subject name");
        subject.setName(UserInput.uploadString());
        subject.setUuid();

        System.out.println("Enter subject topic");
        subject.setTopic(UserInput.uploadString());

        System.out.println("Enter subject range, every phrase divide by /");
        subject.setRange(UserInput.uploadString().split("/"));

        System.out.println("Is video: enter true/false");
        boolean isVideo = Boolean.getBoolean(UserInput.uploadString());

        return subject;
    }
}

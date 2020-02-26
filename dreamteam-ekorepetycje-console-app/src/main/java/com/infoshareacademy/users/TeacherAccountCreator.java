package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.subjects.Subject;
import com.infoshareacademy.subjects.Subjects;
import com.infoshareacademy.userInput.UserInput;

public class TeacherAccountCreator {


    public void create() {
        Teachers teachers = JsonReader.create(new Teachers(), "users.json");
        Subjects subjects = JsonReader.create(new Subjects(), "subjects.json");

        Teacher teacher = createTeacher();
        Subject subject = createSubject();
        subject.setTeacherId(teacher.getUuid());

        teachers.addTeacher(teacher);
        JsonSaver.createJson(teachers, "users.json");

        subjects.addSubject(subject);
        JsonSaver.createJson(subjects, "subjects.json");
    }

    public Teacher createTeacher() {
        Teacher teacher = new Teacher();
        String nickName = "";
        do {
            System.out.println("Enter Nickname");
            nickName = UserInput.uploadString();
        } while (Teachers.teacherAlreadyExist(nickName));

        teacher.setNickName(nickName);
        teacher.setUuid();

        return teacher;
    }

    public Subject createSubject() {
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
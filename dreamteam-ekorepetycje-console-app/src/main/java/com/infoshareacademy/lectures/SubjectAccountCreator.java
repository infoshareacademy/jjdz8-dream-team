package com.infoshareacademy.lectures;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;

import java.util.UUID;

public class SubjectAccountCreator {

    public void createSubjectsAccount(UUID teacherID) {
        SubjectFactory subjectFactory = new SubjectFactory();
        subjectFactory.createSubject();
        subjectFactory.getSubject().setTeacherId(teacherID);
        savingSubjects(subjectFactory.getSubject());
    }

    private void savingSubjects(Subject subject) {
        Subjects subjects = JsonReader.create(new Subjects(), "subjects.json");
        subjects.addSubject(subject);
        JsonSaver.createJson(subjects, "subjects.json");
    }

}

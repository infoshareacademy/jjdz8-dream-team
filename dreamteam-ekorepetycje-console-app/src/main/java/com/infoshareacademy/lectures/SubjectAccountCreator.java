package com.infoshareacademy.lectures;

import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.users.Teacher;

import static com.infoshareacademy.fileOperations.FileNames.SUBJECTS_JSON;

public class SubjectAccountCreator {

    public void createSubjectsAccount(Teacher teacher) {
        SubjectFactory subjectFactory = new SubjectFactory();
        subjectFactory.createSubject();
        subjectFactory.getSubject().setTeacherId(teacher.getId());
        savingSubjects(subjectFactory.getSubject());
    }

    private void savingSubjects(Subject subject) {
        Subjects subjects = JsonReader.create(new Subjects(), SUBJECTS_JSON);
        subjects.addSubject(subject);
        JsonSaver.createJson(subjects, SUBJECTS_JSON);
    }
}

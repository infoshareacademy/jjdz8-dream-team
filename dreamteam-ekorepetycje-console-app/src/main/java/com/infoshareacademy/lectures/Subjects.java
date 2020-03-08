package com.infoshareacademy.lectures;

import com.infoshareacademy.fileOperations.JsonReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import static com.infoshareacademy.fileOperations.FileNames.SUBJECTS_JSON;

public class Subjects {

    private List<Subject> subjectsList = new ArrayList<>();

    public void addSubject(Subject... subjects) {
        this.subjectsList.addAll(Arrays.asList(subjects));
    }

    public List<Subject> getSubjectsList() {
        return subjectsList;
    }

    public List<Subject> findSubjectsForOneTeacher(UUID teacherId) {
        List<Subject> oneTeacherSubjects = new ArrayList<>();
        Subjects subjects = JsonReader.create(new Subjects(), SUBJECTS_JSON);
        for (Subject subject : subjects.getSubjectsList()) {
            if (subject.getTeacherId().equals(teacherId)) {
                oneTeacherSubjects.add(subject);
            }
        }
        return oneTeacherSubjects;
    }

    public Subject findById(Subject editedSubject){
        for (Subject subject : this.subjectsList) {
            if (subject.getId().equals(editedSubject.getId())) {
                return subject;
            }
        }
        return null;
    }

}

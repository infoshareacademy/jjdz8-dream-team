package com.infoshareacademy.repository;

import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.Subjects;
import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestScoped
public class SubjectRepository implements SubjectRepositoryInterface {

    @Override
    public void add(Subject subject) {
        Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);
        subjects.addSubject(subject);
        JsonSaver.createJson(subjects, FileNames.SUBJECTS_JSON);
    }

    @Override
    public void delete(Subject subject) {
        Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);
        subjects.deleteSubject(subject);
        JsonSaver.createJson(subjects, FileNames.SUBJECTS_JSON);
    }

    @Override
    public boolean contains(Optional<Subject> subject) {
        if (subject.isEmpty()) return false;
        Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);
        return subjects.getSubjects().contains(subject.get());
    }

    @Override
    public Optional<Subject> findById(UUID id) {
        Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);
        return Optional.ofNullable(subjects.getSubjects().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null));
    }

    @Override
    public List<Subject> findByName(String name) {
        Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);
        List<Subject> suitableSubjects = new ArrayList<>();
        subjects.getSubjects().forEach(s -> {
            if (s.getName().equalsIgnoreCase(name))
                suitableSubjects.add(s);
        });
        return suitableSubjects;
    }

    @Override
    public List<Subject> findByTopic(String topic) {
        Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);
        List<Subject> suitableSubjects = new ArrayList<>();
        subjects.getSubjects().forEach(s -> {
            if (s.getTopic().equalsIgnoreCase(topic))
                suitableSubjects.add(s);
        });
        return suitableSubjects;
    }

    @Override
    public List<Subject> findAllSubjectForTeacher(UUID id) {
        Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);
        List<Subject> suitableSubjects = new ArrayList<>();
        subjects.getSubjects().forEach(s -> {
            if (s.getTeacherId().equals(id))
                suitableSubjects.add(s);
        });
        return suitableSubjects;
    }

    @Override
    public void updateSubjectName(Subject subject) {
        Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);
        subjects.getSubjects().forEach(s -> {
            if (s.getId().equals(subject.getId())) s.setName(subject.getName());
        });
        JsonSaver.createJson(subjects, FileNames.SUBJECTS_JSON);
    }

    @Override
    public void updateSubjectTopic(Subject subject) {
        Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);
        subjects.getSubjects().forEach(s -> {
            if (s.getId().equals(subject.getId())) s.setTopic(subject.getTopic());
        });
        JsonSaver.createJson(subjects, FileNames.SUBJECTS_JSON);
    }

    @Override
    public void updateSubjectDescription(Subject subject) {
        Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);
        subjects.getSubjects().forEach(s -> {
            if (s.getId().equals(subject.getId())) s.setDescription(subject.getDescription());
        });
        JsonSaver.createJson(subjects, FileNames.SUBJECTS_JSON);
    }

    @Override
    public void updateSubjectIsVideo(Subject subject) {
        Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);
        subjects.getSubjects().forEach(s -> {
            if (s.getId().equals(subject.getId())) s.setVideo(subject.isVideo());
        });
        JsonSaver.createJson(subjects, FileNames.SUBJECTS_JSON);
    }
}

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
import java.util.stream.Collectors;

@RequestScoped
public class SubjectRepository implements SubjectRepositoryInterface {

    private final Subjects subjects = JsonReader.create(new Subjects(), FileNames.SUBJECTS_JSON);

    @Override
    public List<Subject> findAll(){
        return subjects.getSubjects();
    }
    @Override
    public void add(Subject subject) {
        subjects.addSubject(subject);
        JsonSaver.createJson(subjects, FileNames.SUBJECTS_JSON);
    }

    @Override
    public void delete(Subject subject) {
        subjects.deleteSubject(subject);
        JsonSaver.createJson(subjects, FileNames.SUBJECTS_JSON);
    }

    @Override
    public boolean contains(Optional<Subject> subject) {
        if (subject.isEmpty()) return false;
        return subjects.getSubjects().contains(subject.get());
    }

    @Override
    public Optional<Subject> findById(UUID id) {
        return Optional.ofNullable(subjects.getSubjects().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null));
    }

    @Override
    public List<Subject> findByName(String name) {
        List<Subject> suitableSubjects = new ArrayList<>();
        subjects.getSubjects().forEach(s -> {
            if (s.getName().toLowerCase().equalsIgnoreCase(name.toLowerCase()))
                suitableSubjects.add(s);
        });
        return suitableSubjects;
    }

    @Override
    public List<Subject> searchByName(String namePart){

        return subjects.getSubjects().stream().filter(s->s.getName().toLowerCase().contains(namePart.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Subject> searchByTopic(String topicPart) {
        return subjects.getSubjects().stream().filter(s->s.getTopic().toLowerCase().contains(topicPart.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Subject> searchByDescription(String description) {
        return subjects.getSubjects().stream().filter(s->s.getDescription().toLowerCase().contains(description.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Subject> findByTopic(String topic) {
        List<Subject> suitableSubjects = new ArrayList<>();
        subjects.getSubjects().forEach(s -> {
            if (s.getTopic().equalsIgnoreCase(topic))
                suitableSubjects.add(s);
        });
        return suitableSubjects;
    }

    @Override
    public List<Subject> findAllSubjectForTeacher(UUID id) {
        List<Subject> suitableSubjects = new ArrayList<>();
        subjects.getSubjects().forEach(s -> {
            if (s.getTeacherId().equals(id))
                suitableSubjects.add(s);
        });
        return suitableSubjects;
    }

    @Override
    public void updateSubjectName(Subject subject) {
        subjects.getSubjects().forEach(s -> {
            if (s.getId().equals(subject.getId())) s.setName(subject.getName());
        });
        JsonSaver.createJson(subjects, FileNames.SUBJECTS_JSON);
    }

    @Override
    public void updateSubjectTopic(Subject subject) {
        subjects.getSubjects().forEach(s -> {
            if (s.getId().equals(subject.getId())) s.setTopic(subject.getTopic());
        });
        JsonSaver.createJson(subjects, FileNames.SUBJECTS_JSON);
    }

    @Override
    public void updateSubjectDescription(Subject subject) {
        subjects.getSubjects().forEach(s -> {
            if (s.getId().equals(subject.getId())) s.setDescription(subject.getDescription());
        });
        JsonSaver.createJson(subjects, FileNames.SUBJECTS_JSON);
    }

    @Override
    public void updateSubjectIsVideo(Subject subject) {
        subjects.getSubjects().forEach(s -> {
            if (s.getId().equals(subject.getId())) s.setVideo(subject.isVideo());
        });
        JsonSaver.createJson(subjects, FileNames.SUBJECTS_JSON);
    }
}

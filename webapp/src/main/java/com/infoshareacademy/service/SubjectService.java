package com.infoshareacademy.service;

import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.repository.SubjectRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestScoped
public class SubjectService {

    @Inject
    private SubjectRepository repository;

    public Optional<Subject> findById(UUID id) {
        return repository.findById(id);
    }

    public void delete(Subject subject) {
        repository.delete(subject);
    }

    public Subject createSubject(String name, String topic, String description, boolean isVideo, UUID teacherId) {
        Subject subject = new Subject();
        subject.setName(name);
        subject.setTeacherId(teacherId);
        subject.setTopic(topic);
        subject.setDescription(description);
        subject.setVideo(isVideo);
        return subject;
    }

    public void addNewSubject(Subject subject) {
        repository.add(subject);
    }

    public List<Subject> findAllSubjectsForTeacher(UUID teacherId) {
        return repository.findAllSubjectForTeacher(teacherId);
    }
}

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

    public List<Subject> findAll(){
        return repository.findAll();
    }

    public List<Subject> searchByName(String namePart){
        return repository.searchByName(namePart);
    }

    public List<Subject> searchByTopic(String topicPart){
        return repository.searchByTopic(topicPart);
    }

    public List<Subject> searchByDescription(String description){
        return repository.searchByDescription(description);
    }

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
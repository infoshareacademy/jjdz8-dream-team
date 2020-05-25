package com.infoshareacademy.service;

import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.repository.SubjectRepositoryInterface;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class SubjectEditService {

    @Inject
    SubjectRepositoryInterface repository;

    public void add(Subject subject) {
        repository.add(subject);
    }

    public void delete(Subject subject) {
        repository.delete(subject);
    }

    public void editName(Subject subject, String newName) {
            subject = repository.findById(subject.getId()).get();
            subject.setName(newName);
            repository.updateSubjectName(subject);
    }

    public void editTopic(Subject subject, String newTopic) {
            subject = repository.findById(subject.getId()).get();
            subject.setTopic(newTopic);
            repository.updateSubjectTopic(subject);
    }

    public void editDescription(Subject subject, String description) {
            subject = repository.findById(subject.getId()).get();
            subject.setDescription(description);
            repository.updateSubjectDescription(subject);
    }

    public void editIsVideo(Subject subject, String isVideo){
        boolean newIsVideo = Boolean.valueOf(isVideo);
        subject.setVideo(newIsVideo);
        repository.updateSubjectIsVideo(subject);
    }
}

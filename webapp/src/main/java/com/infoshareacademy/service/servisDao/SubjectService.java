package com.infoshareacademy.service.servisDao;

import com.infoshareacademy.dao.Dao;
import com.infoshareacademy.domain.Role;
import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class SubjectService {

    @Inject
    private Dao<Subject> subjectDao;

    @Transactional
    public void createSubject() {
    Subject subject = new Subject();
    subject.setName("matematyka");
    subject.setTopic("ułamki");
    subject.setDescription("dla klas podstawowych");
    subject.setVideo(true);
    subject.setVideoLink("google.com");
    }

}

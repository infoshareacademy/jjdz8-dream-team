package com.infoshareacademy.service.servisDao;

import com.infoshareacademy.Dto.SubjectDto;
import com.infoshareacademy.dao.Dao;
import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.entity.User;

import javax.crypto.spec.OAEPParameterSpec;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@ApplicationScoped
public class SubjectService {

    @Inject
    private Dao<Subject> subjectDao;

    @Inject
    Dao<User> userDao;

    @Transactional
    public List<Subject> findAll() {
        return subjectDao.findAll();
    }

    @Transactional
    public void createSubject(String name, String topic, String description, String videoLink, boolean isVideo, Long userId) {
        Optional<User> user = userDao.findById(userId);
        Subject subject = new Subject();
        subject.setName(name);
        subject.setTopic(topic);
        subject.setDescription(description);
        subject.setVideo(isVideo);
        subject.setVideoLink(videoLink);
        subject.setUser(user.get());
        subjectDao.save(subject);
        user.get().setSubjects(Set.of(subject));
    }

    @Transactional
    public Optional<Subject> findById(long id) {
        return subjectDao.findById(id);
    }

    @Transactional
    public void deleteSubject(Long id){
        Optional<Subject> subject = findById(id);
        subject.ifPresent(s -> subjectDao.delete(s) );
    }

    @Transactional
    public void updateSubject(SubjectDto subjectDto) {
        findById(subjectDto.getId()).ifPresent(subject -> {
            subject.setVideoLink(subjectDto.getVideoLink());
            subject.setName(subjectDto.getName());
            subject.setDescription(subjectDto.getDescription());
            subject.setVideo(subjectDto.isVideo());
            subject.setTopic(subjectDto.getTopic());
            subjectDao.update(subject);
        });
    }

}

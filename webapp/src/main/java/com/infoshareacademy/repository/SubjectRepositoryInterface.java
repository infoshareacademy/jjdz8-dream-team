package com.infoshareacademy.repository;

import com.infoshareacademy.domain.Subject;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Local
public interface SubjectRepositoryInterface {

    List<Subject> findAll();

    void add(Subject subject);

    void delete(Subject subject);

    boolean contains(Optional<Subject> subject);

    Optional<Subject> findById(UUID id);

    List<Subject> findByName(String name);

    List<Subject> findByTopic(String topic);

    List<Subject> findAllSubjectForTeacher(UUID id);

    void updateSubjectName(Subject subject);

    void updateSubjectTopic(Subject subject);

    void updateSubjectDescription(Subject subject);

    void updateSubjectIsVideo(Subject subject);
}

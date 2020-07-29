package com.infoshareacademy.dao;

import com.infoshareacademy.entity.Grade;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@RequestScoped
public class GradesDao implements GradesDaoInt {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Grade grade) {
        entityManager.persist(grade);
    }

    @Override
    public Optional<Grade> findById(long id) {
        return Optional.of(entityManager.find(Grade.class, id));
    }
}

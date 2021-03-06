package com.infoshareacademy.dao;

import com.infoshareacademy.entity.Subject;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class SubjectDao extends AbstractDao<Subject> {

    @Override
    public Optional<Subject> findById(long id) {
        return Optional.of(entityManager.find(Subject.class, id));
    }

    @Override
    public List<Subject> findAll() {
        return entityManager.createQuery("SELECT s FROM Subject s", Subject.class)
                .getResultList();

    }

    @Override
    public List<Subject> findAll(int offset, int limit) {
        return entityManager.createQuery("SELECT s FROM Subject s", Subject.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    @Override
    public Optional<Subject> createNamedQuery(String nameOfNamedQuery, String column, String value) {
        Query query = entityManager.createNamedQuery(nameOfNamedQuery, Subject.class);
        query.setParameter(column, value);
        return Optional.of((Subject) query.getSingleResult());
    }

    @Override
    public Optional<List<Subject>> createNamedQueryForOffSetAndLimit(String nameOfNamedQuery, String column, String value, int offset, int limit){
        Query query = entityManager.createNamedQuery(nameOfNamedQuery, Subject.class);
        return Optional.of(query.setParameter(column, "%"+value+"%")
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList());
    }

    @Override
    public Optional<List<Subject>> createNamedQueryForList(String nameOfNamedQuery, String column, String value) {
        Query query = entityManager.createNamedQuery(nameOfNamedQuery, Subject.class);
        query.setParameter(column, "%"+ value +"%");
        return Optional.ofNullable(query.getResultList());
    }


}

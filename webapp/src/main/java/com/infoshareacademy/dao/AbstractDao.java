package com.infoshareacademy.dao;


import com.infoshareacademy.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T> implements Dao<T> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(T t) {
        entityManager.persist(t);
    }

    @Override
    public void update(T t) {
        entityManager.merge(t);
    }

    @Override
    public void delete(T t) {
        System.out.println(t);
        entityManager.remove(t);
        flashAndClear();
    }

    public void flashAndClear(){
        entityManager.flush();
        entityManager.clear();
    }


}

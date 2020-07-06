package com.infoshareacademy.dao;

import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.entity.User;

import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class UserDao extends AbstractDao<User> {

    @Override
    public Optional<User> findById(long id) {
        return Optional.of(entityManager.find(User.class, id));
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

  /*  @Override
    public List<User> createNamedQuery(String nameOfNamedQuery, String column, String value) {
        return null;
    }*/

    @Override
    public Optional<User> createNamedQuery(String nameOfNamedQuery, String column, String value) {
        Query query = entityManager.createNamedQuery(nameOfNamedQuery, User.class);
        query.setParameter(column, value);
        try {
            query.getSingleResult();
        } catch (NoResultException e) {
            return Optional.ofNullable(null);
        }

        return Optional.of((User) query.getSingleResult());
    }

    @Override
    public Optional<List<User>> createNamedQueryForList(String nameOfNamedQuery, String column, String value) {
        Query query = entityManager.createNamedQuery(nameOfNamedQuery, User.class);
        query.setParameter(column, value);
        return Optional.of(query.getResultList());
    }
}

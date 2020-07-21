package com.infoshareacademy.dao;

import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.entity.User;

import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class UserDao extends AbstractDao<User> implements UserExtendDao {

    @Override
    public Optional<User> findById(long id) {
        return Optional.of(entityManager.find(User.class, id));
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public Optional<User> createNamedQuery(String nameOfNamedQuery, String column, String value) {
        Query query = entityManager.createNamedQuery(nameOfNamedQuery, User.class);
        query.setParameter(column, value);
        try {
            query.getSingleResult();
        } catch (NoResultException e) {
            return Optional.empty();
        }

        return Optional.of((User) query.getSingleResult());
    }

    @Override
    public Optional<List<User>> createNamedQueryForList(String nameOfNamedQuery, String column, String value) {
        Query query = entityManager.createNamedQuery(nameOfNamedQuery, User.class);
        query.setParameter(column, value);
        return Optional.of(query.getResultList());
    }

    @Override
    public Optional<List<Subject>> createNamedQueryForOffSetAndLimit(String nameOfNamedQuery, String column, String value, int offset, int limit) {
        return Optional.empty();
    }


    @Override
    public Optional<List<String>> findAllNickNames(Long id) {
        Query query =  entityManager.createQuery("SELECT u.nickName FROM User u where u.id <> : userId", String.class);
        query.setParameter("userId", id);
        try {
            return Optional.ofNullable(query.getResultList());
        }catch (NoResultException e){
            return Optional.empty();
        }

    }

    @Override
    public Optional<List<String>> findAllEmails(Long id) {
        Query query =  entityManager.createQuery("SELECT u.email FROM User u where u.id <> : userId", String.class);
        query.setParameter("userId", id);
        try {
            return Optional.ofNullable(query.getResultList());
        }catch (NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<String> findPassword(Long id) {
        Query query = entityManager.createQuery("SELECT u.password FROM User u where u.id = : userId", String.class);
        query.setParameter("userId", id);
        try {
            return Optional.of ((String) query.getSingleResult());
        }catch (NoResultException e) {
            return Optional.empty();
        }
    }

}

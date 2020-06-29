package com.infoshareacademy.dao;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface Dao <T>{
    void save(T t);

    void update(T t);

    void delete(T t);

    Optional<T> findById(long id);

    List<T> findAll();

    List<T> createNamedQuery(String nameOfNamedQuery,String column, String value);
}

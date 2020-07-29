package com.infoshareacademy.dao;

import com.infoshareacademy.entity.Grade;

import javax.ejb.Local;
import java.util.Optional;

@Local
public interface GradesDaoInt {

    void save(Grade grade);

    Optional<Grade> findById(long id);
}

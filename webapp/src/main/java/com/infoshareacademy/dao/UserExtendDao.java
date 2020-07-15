package com.infoshareacademy.dao;

import com.infoshareacademy.entity.Subject;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Local
public interface UserExtendDao {

    Optional<List<String>> findAllNickNames(Long id);

    Optional< List<String>> findAllEmails(Long id);

    Optional<String> findPassword(Long id);

 /*   Optional<Set<Subject>> findUserSubjects(Long id);*/
}

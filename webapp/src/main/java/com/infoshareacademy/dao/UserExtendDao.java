package com.infoshareacademy.dao;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface UserExtendDao {

    Optional<List<String>> findAllNickNames(Long id);

    Optional< List<String>> findAllEmails(Long id);

    Optional<String> findPassword(Long id);
}

package com.infoshareacademy.service;

import com.infoshareacademy.domain.User;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Local
public interface Service {

    Optional<User> findByNickName(String nickName);

    Optional<User> findById(UUID id);

    List<User> findUserByPartOfNickname(String part);

    void delete(User user);

    boolean isCorrectPassword(User user, String oldPassword);
}

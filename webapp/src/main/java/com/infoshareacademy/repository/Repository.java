package com.infoshareacademy.repository;

import com.infoshareacademy.domain.User;

import javax.ejb.Local;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.UUID;

@Local
public interface Repository {

     void addUser(User user);

     Optional<User> findByID(UUID id);

     Optional<User> findByNickName(String nickName);

     Optional<User> findByEmail(String email);

     void deleteUser(User user);

     boolean contains(Optional<User> user);

     void updateUserPassword(User user);

     void updateNickname(User user);

     void updateEmail(User user);
}

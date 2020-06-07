package com.infoshareacademy.repository;

import com.infoshareacademy.domain.User;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Local
public interface Repository {

    void addUser(User user);

    List<User> findUsersWithNicknameContainsOrStartsWith(String part);

    Optional<User> findByID(UUID id);

    Optional<User> findByNickName(String nickName);

    Optional<User> findByEmail(String email);

    void deleteUser(User user);

    boolean contains(Optional<User> user);

    void updateUserPassword(UUID id, String password);

    void updateNickname(UUID id, String nickname);

    void updateEmail(UUID id, String email);

    boolean isCorrectPassword(User user, String password);
}

package com.infoshareacademy.service;

import com.infoshareacademy.domain.Role;
import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.repository.Repository;
import com.infoshareacademy.security.PasswordResolver;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RequestScoped
@Named("UserService")
public class UserService implements Service {

    @Inject
    private Repository repository;

    @Override
    public Optional<User> findByNickName(String nickName) {
        return repository.findByNickName(nickName);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findByID(id);
    }

    @Override
    public List<User> findUserByPartOfNickname(String part){
        return repository.findUsersWithNicknameContainsOrStartsWith(part);
    }

    @Override
    public void delete(User user) {
        repository.deleteUser(user);
    }

    public void addUser(User user) {
        repository.addUser(user);
    }

    public User createUser(String nickName, String email, String password, Role role) {
        User user = new User();
        user.setNickName(nickName);
        user.setEmail(email);
        user.setPassword(PasswordResolver.passwordHashing(password));
        user.setRole(role);
        return user;
    }

    @Override
    public boolean isCorrectPassword(User user, String password) {
        return repository.isCorrectPassword(user, password);
    }

    @Override
    public boolean nicknameAlreadyExist(String nickname,UUID id) {
        return repository.nickNameAlreadyExist(nickname, id);
    }

    @Override
    public boolean emailAlreadyExist(String email, UUID id) {
        return repository.emailAlreadyExist(email, id);
    }

}
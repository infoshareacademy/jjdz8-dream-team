package com.infoshareacademy.service;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class UserService implements Service {

    private final Repository repository;

    public UserService(Repository repository) {
        this.repository = repository;
    }

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
        return repository.findUsersWithNicknameContains(part);
    }

    @Override
    public void delete(User user) {
        repository.deleteUser(user);
    }

    @Override
    public boolean isCorrectPassword(User user, String password) {
        return repository.isCorrectPassword(user, password);
    }

}

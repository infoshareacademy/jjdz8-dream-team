package com.infoshareacademy.service;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.repository.Repository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RequestScoped
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

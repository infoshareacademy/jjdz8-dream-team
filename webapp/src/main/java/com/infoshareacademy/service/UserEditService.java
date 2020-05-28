package com.infoshareacademy.service;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.repository.Repository;

public abstract class UserEditService implements EditService {

    private final Repository repository;

    public UserEditService(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void editPassword(User user, String newPassword) {
        repository.updateUserPassword(user.getId(), newPassword);
    }

    @Override
    public void editNickname(User user, String newNickname) {
        repository.updateNickname(user.getId(), newNickname);
    }

    @Override
    public void editEmail(User user, String email) {
        repository.updateEmail(user.getId(), email);
    }

}

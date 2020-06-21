package com.infoshareacademy.service;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.repository.Repository;
import com.infoshareacademy.security.PasswordResolver;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserEditService implements EditService {

    @Inject
    private Repository repository;

    @Override
    public void editPassword(User user, String newPassword) {
        String hashPass = PasswordResolver.passwordHashing(newPassword);
        repository.updateUserPassword(user.getId(), hashPass);
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

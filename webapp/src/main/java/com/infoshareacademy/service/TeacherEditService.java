package com.infoshareacademy.service;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.repository.Repository;
import com.infoshareacademy.security.PasswordResolver;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
public class TeacherEditService {

    @Inject
    @Named("TeachersRepository")
    private Repository repository;

    public void editPassword(User user, String newPassword) {
        user = repository.findByID(user.getId()).get();
        user.setPassword(PasswordResolver.passwordHashing(newPassword));
        repository.updateUserPassword(user);
    }

    public void editNickname(User user, String newNickname) {
        user = repository.findByID(user.getId()).get();
        user.setNickName(newNickname);
        repository.updateNickname(user);
    }

    public void editEmail(User user, String email) {
        user = repository.findByID(user.getId()).get();
        user.setEmail(email);
        repository.updateEmail(user);
    }

}

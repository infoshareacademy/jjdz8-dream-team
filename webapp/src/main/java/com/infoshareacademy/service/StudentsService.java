package com.infoshareacademy.service;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.repository.Repository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;
import java.util.UUID;

@RequestScoped
public class StudentsService {

    @Inject
    @Named("StudentsRepository")
    private Repository repository;

    public Optional<User> findByNickName(String nickName){
        return repository.findByNickName(nickName);
    }

    public Optional<User> findById(UUID id) {
        return repository.findByID(id);
    }

    public void delete(User user) {
        repository.deleteUser(user);
    }
}

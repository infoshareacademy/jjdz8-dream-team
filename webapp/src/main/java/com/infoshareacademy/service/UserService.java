package com.infoshareacademy.service;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.domain.Users;
import com.infoshareacademy.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserService {

    @Inject
    private UserRepository userRepository;

    public Users getAllUsers() {
        return userRepository.getUsers();
    }

    public void addUser(User user) {
        Users users = getAllUsers();
        users.add(user);
        userRepository.saveUsers(users);
    }
}



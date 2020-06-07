package com.infoshareacademy.repository;

import com.infoshareacademy.domain.Users;

public interface UserRepository {

    Users getUsers();

    void saveUsers(Users users);
}

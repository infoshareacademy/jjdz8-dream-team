package com.infoshareacademy.domain;

import java.util.List;

public class Users {
    
    private List<User> users;

    public Users() {
    }

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void add(User user) {
        users.add(user);
    }
}

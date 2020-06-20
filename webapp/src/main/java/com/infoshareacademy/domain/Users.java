package com.infoshareacademy.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Users {

    List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        this.userList.add(user);
    }

    public void deleteUser(UUID id){
        for (int i =0; i< userList.size(); i++){
            if (this.userList.get(i).getId().equals(id)) this.userList.remove(i);
        }
    }
}
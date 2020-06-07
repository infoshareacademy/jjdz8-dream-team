package com.infoshareacademy;

import com.infoshareacademy.domain.ROLE;
import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.domain.Users;
import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.security.PasswordResolver;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setNickName("maciej");
        user.setEmail("maciej@gmail.com");
        user.setPassword(PasswordResolver.passwordHashing("Kamila90@"));
        user.setRole(ROLE.TEACHER);
        user.setAboutMe("i'm teacher");

        User user2 = new User();
        user2.setNickName("damian");
        user2.setEmail("damian@gmail.com");
        user2.setPassword(PasswordResolver.passwordHashing("Kamila90@"));
        user2.setRole(ROLE.STUDENT);

        User user3 = new User();
        user3.setNickName("marek");
        user3.setEmail("marek@gmail.com");
        user3.setPassword(PasswordResolver.passwordHashing("Kamila90@"));
        user3.setRole(ROLE.STUDENT);



        Users users = new Users();
        users.addUser(user);
        users.addUser(user2);
        users.addUser(user3);
        JsonSaver.createJson(users, FileNames.USERS_JSON);



    }
}


package com.infoshareacademy.repository;

import com.infoshareacademy.domain.Users;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Objects;

@RequestScoped
public class InJsonUserRepository implements UserRepository {

    private final String users_json_path;

    @Inject
    private JsonReader jsonReader;

    @Inject
    private JsonSaver jsonSaver;

    public InJsonUserRepository() {
        users_json_path = Objects.requireNonNull(this.getClass()
                                                     .getClassLoader()
                                                     .getResource("users.json"))
                                 .getPath();
    }

    @Override
    public Users getUsers() {
        return jsonReader.create(new Users(), users_json_path);
    }

    @Override
    public void saveUsers(Users users) {
        jsonSaver.createJson(users, users_json_path);
    }
}

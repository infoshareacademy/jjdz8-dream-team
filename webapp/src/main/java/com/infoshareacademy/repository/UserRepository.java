package com.infoshareacademy.repository;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.domain.Users;
import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.security.PasswordResolver;

import javax.enterprise.context.RequestScoped;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestScoped
public class UserRepository implements Repository {

    private static final Users users = JsonReader.create(new Users(), FileNames.USERS_JSON);

    @Override
    public void addUser(User user) {
        users.addUser(user);
        JsonSaver.createJson(users, FileNames.TEACHERS_JSON);
    }

    @Override
    public List<User> findUsersWithNicknameContainsOrStartsWith(String part) {
        return users.getUserList().stream()
                .filter(u -> (u.getNickName().toLowerCase().contains(part) || u.getNickName().toLowerCase().startsWith(part)))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findByID(UUID id) {
        return users.getUserList().stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<User> findByNickName(String nickName) {
        return users.getUserList().stream().filter(u -> u.getNickName().equals(nickName)).findFirst();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return users.getUserList().stream().filter(t -> t.getEmail().equals(email)).findFirst();

    }

    @Override
    public void deleteUser(User user) {
        users.deleteUser(user.getId());
        JsonSaver.createJson(users, FileNames.USERS_JSON);
    }

    @Override
    public boolean contains(Optional<User> user) {
        if (user.isEmpty()) return false;
        else {
            return users.getUserList().contains(user.get());
        }
    }

    @Override
    public void updateUserPassword(UUID id, String password) {
        users.getUserList().forEach(user -> {
            if (user.getId().equals(id)) user.setPassword(password);
        });
        JsonSaver.createJson(users, FileNames.USERS_JSON);
    }

    @Override
    public void updateNickname(UUID id, String nickname) {
        users.getUserList().forEach(user -> {
            if (user.getId().equals(id)) user.setNickName(nickname);
        });
        JsonSaver.createJson(users, FileNames.USERS_JSON);
    }

    @Override
    public void updateEmail(UUID id, String email) {
        users.getUserList().forEach(user -> {
            if (user.getId().equals(id)) user.setEmail(email);
        });
        JsonSaver.createJson(users, FileNames.USERS_JSON);
    }

    @Override
    public boolean isCorrectPassword(User user, String password) {
        String oldPassword = PasswordResolver.passwordHashing(password);
        User checkingUser = users.getUserList().stream()
                .filter(e -> e.getId().equals(user.getId()))
                .findFirst().get();
        if (checkingUser.getPassword().equals(oldPassword) && user.getNickName().equals(checkingUser.getNickName())) {
            return true;
        }

        return false;
    }

    @Override
    public boolean nickNameAlreadyExist(String nickname, UUID id) {
        return users.getUserList().stream()
                .filter(u->!u.getId().equals(id))
                .anyMatch(u ->u.getNickName().equals(nickname));
    }

    @Override
    public boolean emailAlreadyExist(String email, UUID id) {
         return users.getUserList().stream()
                .filter(u->!u.getId().equals(id))
                .anyMatch(u ->u.getEmail().equals(email));
    }

}

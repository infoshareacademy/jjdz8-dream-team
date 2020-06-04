package com.infoshareacademy.repository;

import com.infoshareacademy.domain.Teacher;
import com.infoshareacademy.domain.Teachers;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.security.PasswordResolver;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestScoped
@Named("TeachersRepository")
public class TeachersRepository implements Repository {

    private final Teachers teachers = JsonReader.create(new Teachers(), FileNames.TEACHERS_JSON);

    @Override
    public void addUser(User user) {
        teachers.addTeacher((Teacher) user);
        JsonSaver.createJson(teachers, FileNames.TEACHERS_JSON);
    }

    @Override
    public List<User> findUsersWithNicknameContains(String part) {
        return teachers.getTeachers().stream()
                .filter(teacher -> teacher.getNickName().toLowerCase().contains(part.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<User> findByID(UUID id) {
        return Optional.ofNullable(teachers.getTeachers().stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null));
    }

    @Override
    public Optional<User> findByNickName(String nickName) {
        return Optional.ofNullable(teachers.getTeachers().stream().filter(t -> t.getNickName().equals(nickName)).findFirst().orElse(null));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(teachers.getTeachers().stream().filter(t -> t.getEmail().equals(email)).findFirst().orElse(null));

    }

    @Override
    public void deleteUser(User user) {
        teachers.deleteTeacher(user.getId());
        JsonSaver.createJson(teachers, FileNames.TEACHERS_JSON);
    }

    @Override
    public boolean contains(Optional<User> user) {
        if (user.isEmpty()) return false;
        else {
            if (teachers.getTeachers().contains(user.get())) return true;
        }
        return false;
    }

    @Override
    public void updateUserPassword(UUID id, String password) {
        teachers.getTeachers().forEach(teacher -> {
            if (teacher.getId().equals(id)) teacher.setPassword(password);
        });
        JsonSaver.createJson(teachers, FileNames.TEACHERS_JSON);
    }

    @Override
    public void updateNickname(UUID id, String nickname) {
        teachers.getTeachers().forEach(teacher -> {
            if (teacher.getId().equals(id)) teacher.setNickName(nickname);
        });
        JsonSaver.createJson(teachers, FileNames.TEACHERS_JSON);
    }

    @Override
    public void updateEmail(UUID id, String email) {
        teachers.getTeachers().forEach(teacher -> {
            if (teacher.getId().equals(id)) teacher.setEmail(email);
        });
        JsonSaver.createJson(teachers, FileNames.TEACHERS_JSON);
    }

    @Override
    public boolean isCorrectPassword(User user, String password) {
        String oldPassword = PasswordResolver.passwordHashing(password);
        User checkingUser = teachers.getTeachers().stream()
                .filter(e -> e.getId().equals(user.getId()))
                .findFirst().get();
        if (checkingUser.getPassword().equals(oldPassword) && user.getNickName().equals(checkingUser.getNickName())) {
            return true;
        }

        return false;
    }
}

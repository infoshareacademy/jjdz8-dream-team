package com.infoshareacademy.repository;

import com.infoshareacademy.domain.*;
import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.security.PasswordResolver;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequestScoped
@Named("StudentsRepository")
public class StudentsRepository implements Repository {

    private final Students students = JsonReader.create(new Students(), FileNames.STUDENTS_JSON);

    @Override
    public void addUser(User user) {
        students.addStudent((Student) user);

        JsonSaver.createJson(students, FileNames.SUBJECTS_JSON);
    }
    @Override
    public List<User> findUsersWithNicknameContains(String part) {
        return students.getStudents().stream()
                .filter(student -> student.getNickName().contains(part))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<User> findByID(UUID id) {
        return Optional.ofNullable(students.getStudents().stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null));
    }

    @Override
    public Optional<User> findByNickName(String nickName) {
        return Optional.ofNullable(students.getStudents().stream().filter(t -> t.getNickName().equals(nickName)).findFirst().orElse(null));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(students.getStudents().stream().filter(t -> t.getEmail().equals(email)).findFirst().orElse(null));

    }

    @Override
    public void deleteUser(User user) {
        students.deleteStudent(user.getId());
        JsonSaver.createJson(students, FileNames.STUDENTS_JSON);
    }

    @Override
    public boolean contains(Optional<User> user) {
        if (user.isEmpty()) return false;
        else {
            return students.getStudents().contains(user.get());
        }
    }

    @Override
    public void updateNickname(UUID id, String nickname) {
        students.getStudents().forEach(student -> {
            if (student.getId().equals(id)) student.setNickName(nickname);
        });
        JsonSaver.createJson(students, FileNames.STUDENTS_JSON);
    }

    @Override
    public void updateEmail(UUID id, String email) {
        students.getStudents().forEach(student -> {
            if (student.getId().equals(id)) student.setEmail(email);
        });
        JsonSaver.createJson(students, FileNames.STUDENTS_JSON);
    }

    @Override
    public void updateUserPassword(UUID id, String password) {
        students.getStudents().forEach(student -> {
            if (student.getId().equals(id)) student.setPassword(password);
        });
        JsonSaver.createJson(students, FileNames.STUDENTS_JSON);
    }

    @Override
    public boolean isCorrectPassword(User user, String password) {
        String oldPassword = PasswordResolver.passwordHashing(password);
        User checkingUser = students.getStudents().stream()
                .filter(e -> e.getId().equals(user.getId()))
                .findFirst().get();
        return checkingUser.getPassword().equals(oldPassword) && checkingUser.getNickName().equals(user.getNickName());
    }
}

package com.infoshareacademy.repository;

import com.infoshareacademy.domain.*;
import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Optional;
import java.util.UUID;

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
        JsonSaver.createJson(students,FileNames.STUDENTS_JSON);
    }

    @Override
    public boolean contains(Optional<User> user) {
        if (user.isEmpty()) return false;
        else {
            if (students.getStudents().contains(user.get())) return true;
        }
        return false;
    }

    @Override
    public void updateUserPassword(User user){
        students.getStudents().forEach(teacher -> {if (teacher.getId().equals(user.getId())) teacher.setPassword(user.getPassword());});
        JsonSaver.createJson(students,FileNames.STUDENTS_JSON);
    }

    @Override
    public void updateNickname(User user){
        students.getStudents().forEach(teacher -> {if (teacher.getId().equals(user.getId())) teacher.setNickName(user.getNickName());});
        JsonSaver.createJson(students,FileNames.STUDENTS_JSON);
    }

    @Override
    public void updateEmail(User user){
        students.getStudents().forEach(teacher -> {if (teacher.getId().equals(user.getId())) teacher.setEmail(user.getEmail());});
        JsonSaver.createJson(students,FileNames.STUDENTS_JSON);
    }
}

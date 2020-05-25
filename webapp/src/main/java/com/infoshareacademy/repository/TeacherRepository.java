package com.infoshareacademy.repository;

import com.infoshareacademy.domain.Teacher;
import com.infoshareacademy.domain.Teachers;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;

import javax.enterprise.context.RequestScoped;
import java.util.Optional;
import java.util.UUID;

@RequestScoped
public class TeacherRepository implements Repository{

    private final Teachers teachers = JsonReader.create(new Teachers(),FileNames.TEACHERS_JSON);

    @Override
    public void addUser(User user) {
        teachers.addTeacher((Teacher) user);
        JsonSaver.createJson(teachers, FileNames.TEACHERS_JSON );
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
        JsonSaver.createJson(teachers,FileNames.TEACHERS_JSON);
    }

    @Override
    public boolean contains(Optional<User> user) {
        if (user.isEmpty()) return false;
        else {
            if (teachers.getTeachers().contains(user.get())) return true;
        }
        return false;
    }

    public void updateUserPassword(User user){
        teachers.getTeachers().forEach(teacher -> {if (teacher.getId().equals(user.getId())) teacher.setPassword(user.getPassword());});
        JsonSaver.createJson(teachers,FileNames.TEACHERS_JSON);
    }

    public void updateNickname(User user){
        teachers.getTeachers().forEach(teacher -> {if (teacher.getId().equals(user.getId())) teacher.setNickName(user.getNickName());});
        JsonSaver.createJson(teachers,FileNames.TEACHERS_JSON);
    }

    public void updateEmail(User user){
        teachers.getTeachers().forEach(teacher -> {if (teacher.getId().equals(user.getId())) teacher.setEmail(user.getEmail());});
        JsonSaver.createJson(teachers,FileNames.TEACHERS_JSON);
    }
}

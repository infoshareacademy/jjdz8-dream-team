package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Teachers {

    private List<Teacher> teachersList = new ArrayList<>();

    public List<Teacher> getTeachers() {
        return this.teachersList;
    }

    public void addTeacher(Teacher... teachers) {
        this.teachersList.addAll(Arrays.asList(teachers));
    }

    public static boolean teacherAlreadyExist(String nickName) {
        Teachers teachers = JsonReader.create(new Teachers(), FileNames.TEACHERS_JSON);
        for (Teacher teacher : teachers.getTeachers()) {
            if (teacher.getNickName().equals(nickName)) {

                return true;
            }
        }

        return false;
    }

    public Teacher findByNickname(String nickname) {
        for (Teacher teacher : this.teachersList) {
            if (teacher.getNickName().equals(nickname)) {
                return teacher;
            }
        }

        return new Teacher(nickname);
    }

    public Teacher findById(UUID id) {
        for (Teacher teacher : this.teachersList) {
            if (teacher.getId().equals(id)) {
                return teacher;
            }
        }

        return null;
    }
}



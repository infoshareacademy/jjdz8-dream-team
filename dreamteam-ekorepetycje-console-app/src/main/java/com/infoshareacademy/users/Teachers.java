package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.JsonReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teachers {

    List<Teacher> teachersList;

    public Teachers(Teacher... teachers) {
        this.teachersList = Arrays.asList(teachers);
    }

    public List<Teacher> getTeachers() {
        return teachersList;
    }

    public void addTeacher(Teacher... teachers) {
        if (teachersList.size() == 0) {
            teachersList = new ArrayList<>();
        }
        for (Teacher teacher : teachers) {
            teachersList.add(teacher);
        }
    }

    public static boolean teacherAlreadyExist(String nickName) {
        Teachers teachers = JsonReader.create(new Teachers(), "users.json");
        for (Teacher teacher : teachers.getTeachers()) {
            if (teacher.getNickName().equals(nickName)) {
                System.out.println("NickName already exist, please try again");
                return true;
            }
        }

        return false;
    }
}



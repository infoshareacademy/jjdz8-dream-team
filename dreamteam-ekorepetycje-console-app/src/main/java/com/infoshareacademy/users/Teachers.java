package com.infoshareacademy.users;

import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;

import java.util.*;

public class Teachers {

    private List<Teacher> teachersList = new ArrayList<>();

    public List<Teacher> getTeachers() {
        return this.teachersList;
    }

    public void addTeacher(Teacher... teachers) {
        this.teachersList.addAll(Arrays.asList(teachers));
    }

    public void printTeacherList(){
        int count= 1;
        for (Teacher teacher : teachersList) {
            System.out.println(count+". "+teacher.getNickName());
            count ++;
        }
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

    public Optional<Teacher> findByNickname(String nickname) {
        for (Teacher teacher : this.teachersList) {
            if (teacher.getNickName().equals(nickname)) {
                return Optional.of(teacher);
            }
        }

        return Optional.empty();
    }

    public Optional<Teacher> findById(UUID id) {
        for (Teacher teacher : this.teachersList) {
            if (teacher.getId().equals(id)) {
                return Optional.of(teacher);
            }
        }

        return Optional.empty();
    }
}



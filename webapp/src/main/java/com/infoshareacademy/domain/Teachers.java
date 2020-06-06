package com.infoshareacademy.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Teachers {

    private List<Teacher> teachersList = new ArrayList<>();

    public List<Teacher> getTeachers() {
        return this.teachersList;
    }

    public void addTeacher(Teacher teacher) {
        this.teachersList.add(teacher);
    }

    public void deleteTeacher(UUID id){
        for (int i =0; i< teachersList.size(); i++){
            if (this.teachersList.get(i).getId().equals(id)) this.teachersList.remove(i);
        }
    }
}

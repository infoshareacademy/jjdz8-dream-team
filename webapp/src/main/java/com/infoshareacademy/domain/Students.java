package com.infoshareacademy.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Students {

    private List<Student> studentsList = new ArrayList<>();

    public List<Student> getStudents() {
        return this.studentsList;
    }

    public void addStudent(Student student) {
        this.studentsList.add(student);
    }

    public void deleteStudent(UUID id){
        for (int i = 0; i< studentsList.size(); i++){
            if (this.studentsList.get(i).getId().equals(id)) {
                this.studentsList.remove(i);
            }
        }
    }
}

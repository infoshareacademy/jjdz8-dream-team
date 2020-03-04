package com.infoshareacademy.ratings;

import java.util.ArrayList;
import java.util.List;

public class Students
{


    private List<Student> students=new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }public List<Student> getStudents(){
        return students;
}


}

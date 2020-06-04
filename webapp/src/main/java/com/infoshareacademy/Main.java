package com.infoshareacademy;

import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.Teacher;
import com.infoshareacademy.domain.Teachers;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.fileOperations.FileNames;
import com.infoshareacademy.fileOperations.JsonReader;
import com.infoshareacademy.fileOperations.JsonSaver;
import com.infoshareacademy.repository.StudentsRepository;
import com.infoshareacademy.security.PasswordResolver;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Iwona");
        teacher.setEmail("iwona@gmail.com");
        teacher.setPassword("2add8f9e69e5d0dedd6151b6a224eb21");
        Teachers teachers = JsonReader.create(new Teachers(), FileNames.TEACHERS_JSON);
        teachers.addTeacher(teacher);
        JsonSaver.createJson(teachers,FileNames.TEACHERS_JSON);
    }
}


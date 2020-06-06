package com.infoshareacademy;

import com.infoshareacademy.domain.Subject;
import com.infoshareacademy.domain.User;
import com.infoshareacademy.repository.StudentsRepository;
import com.infoshareacademy.security.PasswordResolver;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.dir") + "/target/resources/teachers.json");

        Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
        Path filePath = Paths.get(root.toString(),"src", "main", "resources", "teachers.json");

    }
}


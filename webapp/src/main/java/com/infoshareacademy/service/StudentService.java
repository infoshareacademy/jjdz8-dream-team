package com.infoshareacademy.service;

import com.infoshareacademy.repository.StudentsRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named("StudentService")
public class StudentService extends UserService {

    @Inject
    public StudentService(StudentsRepository repository) {
        super(repository);
    }
}

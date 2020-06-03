package com.infoshareacademy.service;

import com.infoshareacademy.repository.TeachersRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named("TeacherService")
public class TeacherService extends UserService {

    @Inject
    public TeacherService(TeachersRepository repository) {
        super(repository);
    }

}

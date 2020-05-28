package com.infoshareacademy.service;

import com.infoshareacademy.repository.TeachersRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named("TeacherEditService")
public class TeacherEditService  extends UserEditService{

    @Inject
    public TeacherEditService(TeachersRepository repository) {
        super(repository);
    }
}

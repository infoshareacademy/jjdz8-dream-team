package com.infoshareacademy.service;

import com.infoshareacademy.repository.StudentsRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@RequestScoped
@Named("StudentEditService")
public class StudentEditService extends UserEditService {

    @Inject
    public StudentEditService(StudentsRepository repository) {
        super(repository);
    }
}

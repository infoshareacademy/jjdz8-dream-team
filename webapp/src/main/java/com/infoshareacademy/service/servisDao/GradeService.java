package com.infoshareacademy.service.servisDao;

import com.infoshareacademy.dao.GradesDaoInt;
import com.infoshareacademy.entity.Grade;
import com.infoshareacademy.entity.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@RequestScoped
public class GradeService {

    @Inject
    private GradesDaoInt gradeDao;

    @Transactional
    public void saveGrade(String comment, byte degree, User user){
        Grade grade = new Grade();
        grade.setComment(comment);
        grade.setDegree(degree);
        grade.setUser(user);

        gradeDao.save(grade);
    }
}

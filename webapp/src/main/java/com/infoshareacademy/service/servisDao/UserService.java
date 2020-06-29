package com.infoshareacademy.service.servisDao;

import com.infoshareacademy.dao.Dao;
import com.infoshareacademy.domain.Role;
import com.infoshareacademy.entity.User;


import javax.ejb.TransactionAttribute;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

 @Inject
    private Dao<User> userDao;

@Transactional
    public void createUser() {
        User user = new User();
        user.setNickName("Adam");
        user.setEmail("email@email.com");
        user.setPassword("123");
        user.setRole(Role.ADMINISTRATOR);
        userDao.save(user);
    }
}

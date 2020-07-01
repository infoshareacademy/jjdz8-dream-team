package com.infoshareacademy.service.servisDao;

import com.infoshareacademy.dao.Dao;
import com.infoshareacademy.domain.Role;
import com.infoshareacademy.entity.User;
import com.infoshareacademy.entity.UserQuery;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

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

    @Transactional
    public Optional<User> findByNickname(String nickName){
    return userDao.createNamedQuery(UserQuery.FIND_BY_NICKNAME_QUERY,"userNickName", nickName);
    }

    @Transactional
    public Optional<User> findByEmail(String email) {
    return userDao.createNamedQuery(UserQuery.FIND_BY_EMAIL_QUERY,"userEmail", email);
    }

    @Transactional
    public Optional<Optional<User>> findById(long id) {
    return Optional.of(userDao.findById(id));
    }
}

package com.infoshareacademy.service.servisDao;

import com.infoshareacademy.dao.Dao;
import com.infoshareacademy.domain.Role;
import com.infoshareacademy.entity.User;
import com.infoshareacademy.entity.UserQuery;
import com.infoshareacademy.security.PasswordResolver;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@ApplicationScoped
public class UserService {

 @Inject
    private Dao<User> userDao;


    @Transactional
    public void createUser(String nickname, String email, String password, String role) {
        RoleService service = new RoleService();
        Role userRole = service.returnCorrectRole(role);
        User user = new User();
        user.setNickName(nickname);
        user.setEmail(email);
        user.setPassword(PasswordResolver.passwordHashing(password));
        user.setRole(userRole);
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

    @Transactional
    public boolean isNickNameUnique(String nickName){
        return true;
    }

    @Transactional
    public boolean isEmailUnique(String nickName){
        return true;
    }

    @Transactional
    public void editUserNickNameAndEmail(Long id, String nickName, String email) {
        findById(id).ifPresent(user -> {
            user.get().setEmail(email);
            user.get().setNickName(nickName);
        });
    }
}

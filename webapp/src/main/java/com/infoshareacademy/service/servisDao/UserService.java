package com.infoshareacademy.service.servisDao;

import com.infoshareacademy.dao.Dao;
import com.infoshareacademy.dao.UserExtendDao;
import com.infoshareacademy.domain.Role;
import com.infoshareacademy.entity.Subject;
import com.infoshareacademy.entity.User;
import com.infoshareacademy.entity.UserColumn;
import com.infoshareacademy.entity.UserQuery;
import com.infoshareacademy.security.PasswordResolver;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.nio.file.LinkOption;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@ApplicationScoped
public class UserService {

    @Inject
    private Dao<User> userDao;

    @Inject
    private UserExtendDao userExtendDao;

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
    public Optional<User> findByNickname(String nickName) {
        return userDao.createNamedQuery(UserQuery.FIND_BY_NICKNAME_QUERY, "userNickName", nickName);
    }

    @Transactional
    public Optional<User> findByEmail(String email) {
        return userDao.createNamedQuery(UserQuery.FIND_BY_EMAIL_QUERY, "userEmail", email);
    }

    @Transactional
    public Optional<Optional<User>> findById(long id) {
        return Optional.of(userDao.findById(id));
    }

    @Transactional
    public boolean nickNameAlreadyExist(String nickName, Long id) {
        Optional<List<String>> nicknames = userExtendDao.findAllNickNames(id);
        return nicknames.map(strings -> strings.stream()
                .anyMatch(s -> s.equals(nickName))).orElse(true);
    }

    @Transactional
    public boolean emailAlreadyExist(String email, Long id) {
        Optional<List<String>> emails = userExtendDao.findAllEmails(id);
        return emails.map(strings -> strings.stream()
                .anyMatch(s -> s.equals(email))).orElse(true);
    }

    @Transactional
    public boolean isCorrectPassword(String password, Long id) {
        String codePassword = PasswordResolver.passwordHashing(password);
        Optional<String> correct = userExtendDao.findPassword(id);

        return correct.map(s -> s.equals(codePassword))
                .orElse(false);

    }

    @Transactional
    public void editUserNickNameAndEmail(Long id, String nickName, String email) {
        findById(id).ifPresent(user -> {
            user.get().setEmail(email);
            user.get().setNickName(nickName);
        });
    }

    @Transactional
    public void editUserPassword(Long id, String password) {
        findById(id).ifPresent(user -> user.get().setPassword(PasswordResolver.passwordHashing(password)));
    }

   /* @Transactional
    public Optional<Set<Subject>> findUserSubjects(Long id) {
        return userExtendDao.findUserSubjects(id);
    }*/
}

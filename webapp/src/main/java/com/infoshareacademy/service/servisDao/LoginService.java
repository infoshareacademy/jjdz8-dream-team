package com.infoshareacademy.service.servisDao;


import com.infoshareacademy.entity.User;
import com.infoshareacademy.security.PasswordResolver;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class LoginService {

    @Inject
    UserService userService;

    public boolean isCorrectPasswordForUser(String nickName, String password) {
        String codePassword = PasswordResolver.passwordHashing(password);
        Optional<User> user = userService.findByNickname(nickName);

        if (user.isPresent()) {
            if (user.get().getPassword().equals(codePassword)) return true;
        }
        
        return false;
    }
}

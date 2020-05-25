package com.infoshareacademy.service;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.repository.TeacherRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Optional;

@RequestScoped
public class UserEditService {

    @Inject
    TeacherRepository repository = new TeacherRepository();

    public void editPassword(User user, String newPassword){
           user = repository.findByID(user.getId()).get();
           user.setPassword(newPassword);
           repository.updateUserPassword(user);
    }

    public void editNickname(User user, String newNickname) {
            user = repository.findByID(user.getId()).get();
            user.setNickName(newNickname);
            repository.updateNickname(user);
    }

    public void editEmail(User user, String email) {
            user = repository.findByID(user.getId()).get();
            user.setEmail(email);
            repository.updateEmail(user);
    }

}

package com.infoshareacademy.service;

import com.infoshareacademy.domain.User;

import javax.ejb.Local;

@Local
public interface EditService {

    void editPassword(User user, String newPassword);

    void editNickname(User user, String newNickname);

    void editEmail(User user, String email);
}

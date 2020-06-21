package com.infoshareacademy.validation;

import com.infoshareacademy.domain.User;
import com.infoshareacademy.service.Service;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.UUID;

import static com.infoshareacademy.servlet.users.EditUserAccountServlet.*;
import static com.infoshareacademy.servlet.users.UserLoginServlet.SESSION_MARK;

public class UserValidator {

    public static boolean isCorrectNickname(String nickName, HttpSession session, Service service){
        if (StringUtils.isEmpty(nickName)) {
            session.setAttribute(EMPTY_NICKNAME, "nickName cannot be empty");
            return false;
        }
        if (service.nicknameAlreadyExist(nickName,(UUID) session.getAttribute(SESSION_MARK))){
            session.setAttribute("nickNameExist", nickName);
            return false;
        }
        else session.setAttribute("nickName", nickName);

        return true;
    }

    public static boolean isCorrectEmail(String email, HttpSession session, Service service){
        if (StringUtils.isEmpty(email)) {
            session.setAttribute(EMPTY_EMAIL, "email cannot be empty");
            return false;
        }
        if (service.emailAlreadyExist(email,(UUID)session.getAttribute(SESSION_MARK))){
            session.setAttribute("emailExist",email);
            return false;
        }
        else session.setAttribute("email", email);
        return true;
    }

    public static boolean isCorrectPassword(String oldPassword, Service userService, User user) {
       return !StringUtils.isEmpty(oldPassword) && userService.isCorrectPassword(user, oldPassword);
    }

    public static boolean isCorrectFormatOfNewPassword(String password) {
        return !StringUtils.isEmpty(password) && isCorrectPasswordFormat(password);
    }

    public static boolean isCorrectPasswordFormat(String userPassword) {
        return userPassword.matches("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,20})");
    }
}

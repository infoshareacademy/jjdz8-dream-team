package com.infoshareacademy.validation;

import com.infoshareacademy.service.Service;
import com.infoshareacademy.service.UserService;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpSession;

import java.util.UUID;

import static com.infoshareacademy.servlet.users.EditUserAccountServlet.EMPTY_EMAIL;
import static com.infoshareacademy.servlet.users.EditUserAccountServlet.EMPTY_NICKNAME;
import static com.infoshareacademy.servlet.users.UserLoginServlet.SESSION_MARK;


public class ParameterValidator {

    public static boolean isIncorrectCorrectParameter(String parameter) {
        return (parameter == null || parameter.isEmpty());
    }

}

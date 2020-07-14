package com.infoshareacademy.service.servisDao;

import com.infoshareacademy.domain.ROLE;

public class RoleService {

    public ROLE returnCorrectRole(String role){
        if (role.equalsIgnoreCase("TEACHER")) return ROLE.TEACHER;
        if (role.equalsIgnoreCase("STUDENT")) return ROLE.STUDENT;
        else return ROLE.ADMINISTRATOR;
    }
}

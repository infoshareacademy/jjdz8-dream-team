package com.infoshareacademy.service.servisDao;

import com.infoshareacademy.domain.Role;

public class RoleService {

    public Role returnCorrectRole(String role){
        System.out.println(role);
        if (role.toUpperCase().equals("TEACHER")) return Role.TEACHER;
        if (role.toUpperCase().equals("STUDENT")) return Role.STUDENT;
        else return Role.ADMINISTRATOR;
    }
}

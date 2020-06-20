package com.infoshareacademy.service;

import com.infoshareacademy.domain.Role;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class RoleService {
    public Role roleFromString(String whoIAm) {
        for (Role r : Role.values()) {
            if (r.toString().equalsIgnoreCase(whoIAm)) {
                return r;
            }
        }
        throw new IllegalArgumentException("No constant with text " + whoIAm + " found");
    }
}

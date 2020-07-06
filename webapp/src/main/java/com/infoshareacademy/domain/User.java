package com.infoshareacademy.domain;

import com.infoshareacademy.domain.Role;
import com.infoshareacademy.entity.Subject;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static com.infoshareacademy.entity.UserColumn.*;
import static com.infoshareacademy.entity.UserColumn.EMAIL;
import static com.infoshareacademy.entity.UserQuery.FIND_BY_EMAIL_QUERY;
import static com.infoshareacademy.entity.UserQuery.FIND_BY_NICKNAME_QUERY;

public class User {

    private Long id;

    private String nickName;

    private String email;

    private Role role;

    private String password;

    private LocalDate dateOfRegistration;

    private Set<com.infoshareacademy.entity.Subject> subjects = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public Set<com.infoshareacademy.entity.Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

}
package com.infoshareacademy.domain;

import javax.annotation.security.DeclareRoles;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@DeclareRoles({"Administrator","teacher","student"})
public class User {

    private String password;

    private UUID id;

    private String nickName;

    private String email;

    private ROLE role;

    private String aboutMe;

    private LocalDate dateOfRegistration;

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
        this.id = UUID.randomUUID();
        this.dateOfRegistration = LocalDate.now();
    }

    public UUID getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getId(), user.getId()) &&
                Objects.equals(getNickName(), user.getNickName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassword(), getId(), getNickName());
    }

    @Override
    public String toString() {
        return "User{" +
                ", id=" + id +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

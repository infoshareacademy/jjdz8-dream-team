package com.infoshareacademy.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

public class User {

    private String password;

    private UUID id;

    private String nickName;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(){

    }
    public User(String nickName) {
        this.id = UUID.randomUUID();
        this.nickName = nickName;
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

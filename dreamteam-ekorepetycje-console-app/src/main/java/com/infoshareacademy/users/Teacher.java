package com.infoshareacademy.users;

import java.util.UUID;

public class Teacher {
    private UUID uuid;

    private String nickName;

    private double averageRating;

    public void setUuid() {
        uuid = UUID.randomUUID();
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getNickName() {
        return nickName;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + uuid +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

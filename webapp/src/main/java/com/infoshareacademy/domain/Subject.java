package com.infoshareacademy.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class Subject {

    private UUID id;

    private UUID teacherId;

    private String name;

    private String topic;

    private String description;

    private boolean isVideo;

    public Subject(){
        this.id = UUID.randomUUID();
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return isVideo() == subject.isVideo() &&
                Objects.equals(getId(), subject.getId()) &&
                Objects.equals(getTeacherId(), subject.getTeacherId()) &&
                Objects.equals(getName(), subject.getName()) &&
                Objects.equals(getTopic(), subject.getTopic()) &&
                Objects.equals(getDescription(), subject.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTeacherId(), getName(), getTopic(), getDescription(), isVideo());
    }

}

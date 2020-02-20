package com.infoshareacademy.subjects;

import java.util.Arrays;
import java.util.UUID;

public class Subject {
    private UUID uuid;

    private UUID teacherId;

    private String name;

    private String topic;

    private String[] range;

    boolean isVideo;

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public void setRange(String[] range) {
        this.range = range;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setUuid() {
        uuid = UUID.randomUUID();

    }

    public UUID getUuid() {
        return this.uuid;
    }

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }

    public String[] getRange() {
        return range;
    }

    public boolean isVideo() {
        return isVideo;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + uuid +
                ", teacherId=" + teacherId +
                ", name='" + name + '\'' +
                ", topic='" + topic + '\'' +
                ", range=" + Arrays.toString(range) +
                ", isVideo=" + isVideo +
                '}';
    }
}

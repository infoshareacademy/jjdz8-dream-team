
package com.infoshareacademy.subjects;

import java.util.Arrays;
import java.util.UUID;

public class Subject {
    Subject RankingFactory;
    private UUID id;

    private UUID teacherId;

    private String name;

    private String topic;

    private String[] range;

    private boolean isVideo;

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

    public void setRange(String[] range) {
        this.range = range;
    }

    public void setUuid() {
        id = UUID.randomUUID();

    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", name='" + name + '\'' +
                ", topic='" + topic + '\'' +
                ", range=" + Arrays.toString(range) +
                ", isVideo=" + isVideo +
                '}';
    }
}
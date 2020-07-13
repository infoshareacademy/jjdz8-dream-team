package com.infoshareacademy.Dto;

import com.infoshareacademy.entity.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

import static com.infoshareacademy.entity.SubjectColumn.*;
import static com.infoshareacademy.entity.SubjectQuery.*;

public class SubjectDto {

    private long id;

    private String name;

    private String topic;

    private String description;

    private boolean isVideo;

    private String videoLink;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }



    @Override
    public String toString() {
        return "SubjectDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                ", isVideo=" + isVideo +
                ", videoLink='" + videoLink + '\'' +
                '}';
    }
}



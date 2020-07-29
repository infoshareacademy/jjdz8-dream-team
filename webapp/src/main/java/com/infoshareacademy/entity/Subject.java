package com.infoshareacademy.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static com.infoshareacademy.entity.SubjectColumn.*;
import static com.infoshareacademy.entity.SubjectQuery.*;

@Entity
@Table(name = "subjects")
@NamedQueries({
        @NamedQuery(
                name = FIND_BY_NAME_QUERY,
                query = "SELECT s from Subject s where s.name = :" + NAME
        ),
        @NamedQuery(
                name = FIND_BY_NAME_WHERE_NAME_IS_LIKE,
                query = "SELECT s from Subject s where s.name like :" + NAME
        ),
        @NamedQuery(
                name = FIND_BY_TOPIC_WHERE_TOPIC_IS_LIKE,
                query = "SELECT s from Subject s where s.topic like :" + TOPIC
        ),
        @NamedQuery(
                name = FIND_BY_DESCRIPTION_WHERE_DESCRIPTION_IS_LIKE,
                query = "SELECT s from Subject s where s.description like :" + DESCRIPTION
        ),
        @NamedQuery(
                name = FIND_BY_TOPIC_QUERY,
                query = "SELECT s from Subject s where s.topic = :" + TOPIC
        ),
        @NamedQuery(
                name = FIND_BY_DESCRIPTION_QUERY,
                query = "SELECT s from Subject s where s.description = :" + DESCRIPTION
        ),
        @NamedQuery(
                name = FIND_BY_IS_VIDEO_QUERY,
                query = "SELECT s from Subject s where s.isVideo = :" + IS_VIDEO
        ),
        @NamedQuery(
                name = FIND_BY_USER_ID,
                query = "SELECT s from Subject s where s.user = :" + SUBJECT_USER
        )
})
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String name;

    @Basic
    private String topic;

    @Basic
    private String description;

    @Basic
    private boolean isVideo;

    @Basic
    private String videoLink;

    @Column(name = "date_of_creation")
    @CreationTimestamp
    private LocalDate dateOfCreation;

    @ManyToOne()
    @JoinColumn(name = "user_ID")
    private User user;

    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Set<Grade> grades = new HashSet<>();

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

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


package com.infoshareacademy.users;


<<<<<<< HEAD
import java.util.UUID;

public class Teacher implements Comparable<Teacher> {

    private String password;

    private UUID id;

    private String nickName;
=======
public class Teacher extends User {
>>>>>>> develop

    private double averageRating;

    public Teacher(String nickName) {
<<<<<<< HEAD
        this.id = UUID.randomUUID();
        this.nickName = nickName;
    }

    public Teacher() {

    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
=======
        super(nickName);
>>>>>>> develop
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public int compareTo(Teacher teacher) {
        if (averageRating > teacher.getAverageRating()) return 1;
        if (averageRating < teacher.getAverageRating()) return -1;
        return 0;
    }

}

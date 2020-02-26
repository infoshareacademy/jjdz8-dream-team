package com.infoshareacademy.users;

public class TeacherFactory {

    private Teacher teacher;

    public Teacher make(String nickname) {
        this.teacher = new Teacher();
        this.teacher.setUuid();
        this.teacher.setPassword();
        this.teacher.setNickName(nickname);

        return teacher;
    }
}

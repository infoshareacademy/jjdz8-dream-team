//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.infoshareacademy.users;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TeacherTerm {
    private String nickName;
    private UUID teacherId;
    private Map<LocalDate, String> terms;

    public TeacherTerm(String nickName) {
        this.nickName = nickName;
        this.terms = new HashMap();
    }

    public TeacherTerm(String nickName, UUID teacherId) {
        this.teacherId = teacherId;
        this.nickName = nickName;
        this.terms = new HashMap();
    }

    public Map<LocalDate, String> getTerms() {
        return this.terms;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    public void addTerm(LocalDate d, String subject) {
        this.terms.put(d, subject);
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public UUID getTeacherId() {
        return this.teacherId;
    }

    public String toString() {
        return "Avaible teacher terms of nickName = '" + this.nickName + "', (teacherId = " + this.teacherId + "), terminy = " + this.terms + "}";
    }
}

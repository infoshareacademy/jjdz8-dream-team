package com.infoshareacademy.users;

import com.infoshareacademy.menu.MenuAppearance;
import com.infoshareacademy.menu.MenuOption;

public class Teacher extends User implements Comparable<Teacher> {
    private double averageRating;

    public Teacher(String nickName) {
        super(nickName);
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


    public void editTeacherAccount() {
        TeacherAccount account = new TeacherAccount();
        if (account.logIn()) {
            MenuAppearance.showDataEditMenu();
            MenuOption.chooseDataToEdit(account);
        }
    }
}
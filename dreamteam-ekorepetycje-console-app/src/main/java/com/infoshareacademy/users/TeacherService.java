package com.infoshareacademy.users;

import com.infoshareacademy.menu.MenuAppearance;
import com.infoshareacademy.menu.MenuOption;


public class TeacherService {

    public void createTeacherAccount() {
        TeacherAccountCreator account = new TeacherAccountCreator();
        account.createAccount();
    }

    public void editTeacherAccount() {
        TeacherAccount account = new TeacherAccount();
        if (account.logIn()) {
            MenuAppearance.showDataEditMenu();
            MenuOption.chooseDataToEdit(account);
        }
    }
}



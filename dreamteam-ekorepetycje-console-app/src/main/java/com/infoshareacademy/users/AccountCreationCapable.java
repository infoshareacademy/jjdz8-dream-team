package com.infoshareacademy.users;

public interface AccountCreationCapable {

    default void createAccount(){
        createUser();
        saveAccount();
    };
    void createUser();
    void saveAccount();



}

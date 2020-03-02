package com.infoshareacademy.userOutput;

public class CommandPrinter {

    public static void printPasswordRules() {
        System.out.println("************************************");
        System.out.println("      Please enter new password     ");
        System.out.println("************************************");
        System.out.println("Be between 8 and 20 characters long\n" +
                "Contain at least one digit.\n" +
                "Contain at least one lower case character.\n" +
                "Contain at least one upper case character.\n" +
                "Contain at least on special character from [ @ # $ % ! . ].");
    }

    public static void printSubjectsHead() {
        System.out.println("********************************************");
        System.out.println("            All your subjects                ");
        System.out.println("********************************************");
    }

    public static void enterNickname() {
        System.out.println("***************************************");
        System.out.println("Enter Nickname");
        System.out.println("***************************************");
    }

    public static void enterYourPassword() {
        System.out.println("***************************************");
        System.out.println("Please enter password");
        System.out.println("***************************************");
    }

    public static void enterYourOldPassword() {
        System.out.println("***************************************");
        System.out.println("Please enter old password");
        System.out.println("***************************************");
    }

    public static void yourPasswordSuccesfullyChanged() {
        System.out.println("***************************************");
        System.out.println("Your password was succesfully change");
        System.out.println("***************************************");
    }

    public static void yourNicknameWasChange() {
        System.out.println("***************************************");
        System.out.println("Yours nickname was succesfully changed");
        System.out.println("***************************************");
    }

    public static void enterNewNickname() {
        System.out.println("***************************************");
        System.out.println("Please enter new NickName: ");
        System.out.println("***************************************");

    }

    public static void doYouWantEnterSubject() {
        System.out.println("****************************************");
        System.out.println("Do you want enter subject? Yes/No");
        System.out.println("****************************************");
    }

    public static void accountSuccesfullySaved() {
        System.out.println("*********************************************");
        System.out.println("Your account was safely saved!!");
        System.out.println("*****************************************");
    }

    public static void accessGranted() {
        System.out.println("***************************************");
        System.out.println("Access Granted! Welcome!");
        System.out.println("***************************************");
    }
}
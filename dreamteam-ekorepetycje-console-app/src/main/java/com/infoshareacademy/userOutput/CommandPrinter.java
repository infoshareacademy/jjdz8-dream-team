package com.infoshareacademy.userOutput;

public class CommandPrinter {

    private static final String ENTER_NICKNAME = "Enter nickname";
    private static final String NEW_NICKNAME = "Enter new nickname";
    private static final String ENTER_PASSWORD = "Enter password";
    private static final String ENTER_OLD_PASSWORD = "Enter old password";
    private static final String ENTER_NEW_PASSWORD = "Please enter new Password\n (8-20 characters,at lest one digit,lower " +
            "and upper chase character, special character[@,!*$...])";
    private static final String ALL_SUBJECTS = "All your subjects";
    private static final String PASSWORD_CHANGED = "Yours password was successfully changed";
    private static final String NICKNAME_CHANGED = "Yours nickname was successfully changed";
    private static final String DECIDE_TO_ADD_SUBJECT = "Do you want enter subject? Yes/no";
    private static final String ACCOUNT_SAVED = "Your account was safely saved";
    private static final String ACCESS_GRANTED = "Welcome. Access granted.";
    private static final String CHOOSE_TEACHER = "Choose teacher.";
    private static final String ENTER_SUBJECT = "Enter subject.";

    public static void enterNicknameHeader() {
        displayMessage(ENTER_NICKNAME);
    }

    public static void showPasswordRules() {
        displayMessage(ENTER_NEW_PASSWORD);
    }

    public static void showSubjectsHeader() {
        displayMessage(ALL_SUBJECTS);
    }

    public static void enterYourPasswordHeader() {
        displayMessage(ENTER_PASSWORD);
    }

    public static void enterYourOldPasswordHeader() {
        displayMessage(ENTER_OLD_PASSWORD);
    }

    public static void passwordChangedHeader() {
        displayMessage(PASSWORD_CHANGED);
    }

    public static void yourNicknameWasChangeHeader() {
        displayMessage(NICKNAME_CHANGED);
    }

    public static void enterNewNicknameHeader() { displayMessage(NEW_NICKNAME); }

    public static void doYouWantEnterSubjectHeader() {
        displayMessage(DECIDE_TO_ADD_SUBJECT);
    }

    public static void accountSuccessfullySavedHeader() {
        displayMessage(ACCOUNT_SAVED);
    }

    public static void accessGrantedHeader() {
        displayMessage(ACCESS_GRANTED);
    }

    public static void chooseTeacher() { displayMessage(CHOOSE_TEACHER); }

    public static void enterSubject() { displayMessage(ENTER_SUBJECT); }

    private static void displayMessage(String message) {
        System.out.println("*********************************************************************");
        System.out.println("                          " + message);
        System.out.println("*********************************************************************");
    }
}
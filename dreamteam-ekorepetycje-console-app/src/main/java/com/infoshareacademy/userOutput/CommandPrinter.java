package com.infoshareacademy.userOutput;

import com.infoshareacademy.userInput.UserInput;

public class CommandPrinter {

    public static void printPasswordRules (){
        System.out.println("******Please enter new password******\nBe between 8 and 10 characters long\n" +
                "Contain at least one digit.\n" +
                "Contain at least one lower case character.\n" +
                "Contain at least one upper case character.\n" +
                "Contain at least on special character from [ @ # $ % ! . ].");
    }
}

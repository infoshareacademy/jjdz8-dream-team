package com.infoshareacademy.userInput;

import java.util.Scanner;

public class UserInput {

    public static int upLoadInt() {
        Integer userChoice = 0;
        while (userChoice == 0) {
            try {
                Scanner scanner = new Scanner(System.in);
                userChoice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Incorrect format. Please try again");
            }
        }
        return userChoice;
    }

    public static String uploadString() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}

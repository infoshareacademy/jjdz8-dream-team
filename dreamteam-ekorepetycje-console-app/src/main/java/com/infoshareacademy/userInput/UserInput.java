package com.infoshareacademy.userInput;

import java.util.Scanner;

public class UserInput {

    public static int upLoadInt() {
        int userChoice = 0;
        boolean isCorrect = false;
        while (isCorrect == false) {
            try {
                Scanner scanner = new Scanner(System.in);
                userChoice = scanner.nextInt();
                isCorrect = true;
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

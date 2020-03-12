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

    public static double upLoadDouble(double min, double max) {
        double userChoice =0;
        while (userChoice < min || userChoice > max) {
            try {
                Scanner scanner = new Scanner(System.in);
                userChoice = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Incorrect format. Please try again");
            }
            System.out.println("Please enter value between "+min+" - "+ max);
        }

        return userChoice;
    }

    public static String uploadString() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}

package com.infoshareacademy.operation;

import java.text.DecimalFormat;

public class Calculator {

    public static String roundToTwoDecimals(double number) {
        DecimalFormat f = new DecimalFormat("##.00");
        return f.format(number);
    }
}

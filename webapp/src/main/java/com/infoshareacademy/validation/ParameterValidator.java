package com.infoshareacademy.validation;

public class ParameterValidator {

    public static boolean isIncorrectCorrectParameter(String parameter) {
        return (parameter == null || parameter.isEmpty());
    }
}

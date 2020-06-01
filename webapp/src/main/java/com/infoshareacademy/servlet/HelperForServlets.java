package com.infoshareacademy.servlet;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class HelperForServlets {

    public static final String ERROR_MESSAGE ="please login first";


    public static boolean isIncorrectCorrectParameter(String parameter) {
        return (parameter == null || parameter.isEmpty());
    }

    public static boolean isValidSession(HttpSession session, String attributeName) {
        return session.getAttribute(attributeName) != null && !attributeName.isEmpty();
    }

    public static void invalidateAttributes(HttpSession session, String... attributeNames) {
        for (String attributeName : attributeNames) {
            if (session.getAttribute(attributeName) != null) {
                session.removeAttribute(attributeName);
            }
        }
    }

    public static void putCorrectDataToDataModel(String modelKey, String modelValue, Map<String, Object> dataModel) {
        if (!modelValue.isEmpty()) {
            dataModel.put(modelKey, modelValue);
        }
    }

    public static String getAttributeValue(HttpSession session, String attributeName) {
        String attribute = "";
        if (session.getAttribute(attributeName) != null) {
            attribute = (String) session.getAttribute(attributeName);
        }
        return attribute;
    }
}

package com.infoshareacademy.resolver;

import java.io.InputStream;
import java.util.Scanner;

public class InputResolver {

    public static String inputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        return scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
    }

}

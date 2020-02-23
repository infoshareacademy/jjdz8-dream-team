package com.infoshareacademy.FileSaver;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;

public class ObjectFromJsonCreator<T> {

    public static <T> T create(T object, String fileName) {
        if (doNotExistAlready(fileName)) {
            return object;
        } else {
            Gson gson = new Gson();
            try {
                object = gson.fromJson(new FileReader(fileName), (Type) object.getClass());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return object;
    }

    public static boolean doNotExistAlready(String fileName) {
        File file = new File(fileName);

        return !file.exists() || file.length() == 0;
    }
}

package com.infoshareacademy.fileOperations;

import com.google.gson.Gson;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;

@ApplicationScoped
public class JsonReader {

    public <T> T create(T object, String fileName) {
        if (!doesFileExist(fileName)) {
            return object;
        } else {
            try {
                object = new Gson().fromJson(new FileReader(fileName), (Type) object.getClass());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return object;
    }

    private boolean doesFileExist(String fileName) {
        File file = new File(fileName);
        return file.exists() && file.length() > 0;
    }
}

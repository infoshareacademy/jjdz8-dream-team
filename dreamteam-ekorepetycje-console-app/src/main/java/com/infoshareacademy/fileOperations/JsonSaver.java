package com.infoshareacademy.fileOperations;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.Writer;

public class JsonSaver {

    public static <T> void createJson(T object, String filename) {
        try {
            Writer writer = new FileWriter(filename);
            new Gson().toJson(object, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

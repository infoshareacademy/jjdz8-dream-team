package com.infoshareacademy.fileOperations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.enterprise.context.ApplicationScoped;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

@ApplicationScoped
public class JsonSaver {

    public <T> void createJson(T object, String filename) {
        try (Writer writer = new FileWriter(filename)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(object, writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

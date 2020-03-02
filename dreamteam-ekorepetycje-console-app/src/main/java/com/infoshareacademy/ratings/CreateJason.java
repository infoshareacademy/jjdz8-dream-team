package com.infoshareacademy.ratings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CreateJason {
    public static <T> void createJson(T object, String filename) throws Exception {
        try (Writer writer = new FileWriter(filename)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(object, writer);
            writer.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }



}


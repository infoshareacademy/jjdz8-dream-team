package com.infoshareacademy.KasiaGson;

import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

   // List<User> persons = createList();

    private static List<User> createList() {

        List<User> users = new ArrayList<>();

        users.add(new User("Patryk",5));
        users.add(new User("Ela",4));
        users.add(new User("Marek",6));


        return users;
    }

    public static void main(String[] args) throws IOException {
        List<User> users= createList();

        for (int i = 0; i < 2; i++) {


            Scanner scan = new Scanner(System.in);

            System.out.println("Podaj imie nauczyciela");
            String name = scan.nextLine();
            System.out.println("Podaj ocene jaka wystawiasz nauczycielowi od 2 do 6");
            double grade = scan.nextDouble();
           users.add(new User(name,grade));

        }
        Writer writer = new FileWriter("user.json");


        new Gson().toJson(users, writer);

        writer.flush();


        String fileName = "user.json";
        Path path = Paths.get(fileName);

        try (Reader reader = Files.newBufferedReader(path,
                StandardCharsets.UTF_8)) {

            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(reader);

            JsonArray array = tree.getAsJsonArray();

            for (JsonElement element : array) {

                if (element.isJsonObject()) {

                    JsonObject usery = element.getAsJsonObject();

                    System.out.println("********************");
                    System.out.println(usery.get("name").getAsString());
                    System.out.println(usery.get("grade").getAsString());

                    }
                }
            }
        }
    }

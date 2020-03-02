package com.infoshareacademy.ratings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

//import static kasia50.CreateJason.createJson;


public class CurlyBraces {
    public String getJsonString() {
        return this.jsonString;
    }

    private String jsonString;
    public void WriteToFile2(String jsonString) {
        try {
            FileWriter myWriter = new FileWriter("filename2.txt");
            myWriter.write(jsonString);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void CurlyBraces() throws IOException {

      /*  BufferedReader br = new BufferedReader(new FileReader("jason60.json"));
        try {

            //String data =line.replaceAll( "\"\\\\([^(*)^]\\\\)\" "," ");
            //String data = line.replaceAll( "\"\\\\([^()]*\\\\)\" "," ");
            //String data = line.replaceAll( "\"[{}]\" \")," ");
           String jsonString =line.replaceAll("(\"\\[\")","").replaceAll("(\"\\]\")","");
           //String jsonString =line.replaceAll("(\"\\[\")","").replaceAll("(\"\\]\")","");
//String jsonString=line.replaceAll( "[\\[\\]\\]]","");
           //jsonString.replaceAll("(\"\\]\")","\\]\"").replaceAll("(\"\\[\")","\"\\[");

             //jsonString = line.replaceAll("^\\[", "").replaceAll("\\]$", "").replaceAll("} *,\\r\\n", "}\r\n");
           // line.replace("[", "");
            //line.replace("]", "");
             {*/

        BufferedReader br = new BufferedReader(new FileReader("jason60.json"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            //String data =line.replaceAll( "\"\\\\([^(*)^]\\\\)\" "," ");
            //String data = line.replaceAll( "\"\\\\([^()]*\\\\)\" "," ");
            //String data = line.replaceAll( "\"[{}]\" \")," ");
            String jsonString = line.replaceAll("(\"\\[\")", "\\[\"").replaceAll("(\"\\]\")", "\"\\]");
            //System.out.println(jsonString);
            //String  jsonString = line.replaceAll("^\\[", "").replaceAll("\\]$", "").replaceAll("} *,\\r\\n", "}\r\n");
            //line.replace("[", "");
            // line.replace("]", "");

            while (jsonString != null) {

                //String data =line.replaceAll( "\"\\\\([^(*)^]\\\\)\" "," ");
                //String data = line.replaceAll( "\"\\\\([^()]*\\\\)\" "," ");
                //String data = line.replaceAll( "\"[{}]\" \")," ");
               // jsonString = line.replaceAll("(\"\\[\")", "\\[\"").replaceAll("(\"\\]\")", "\"\\]");

                sb.append(jsonString);
                sb.append(System.lineSeparator());
                jsonString = br.readLine();
                System.out.println(jsonString);
                Path filePath = Paths.get( "filename.txt");

                try
                {
                    //Write content to file
                    Files.writeString(filePath, jsonString, StandardOpenOption.APPEND);

                    //Verify file content
                    String content = Files.readString(filePath);

                    System.out.println(content);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

        } finally {
        };



    }}
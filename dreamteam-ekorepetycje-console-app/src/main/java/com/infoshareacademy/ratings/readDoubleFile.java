package com.infoshareacademy.ratings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class readDoubleFile {
    private String texts;
    public String getText() {
        return this.texts;
    }
    public String readDoubleFile2(String file) throws IOException {
     String path = "filename.txt";
     String file_name="filename.txt";



         BufferedReader br = new BufferedReader(new FileReader(file));
         try {
             String line;
             while ((line = br.readLine()) != null) {
                 //br.write (line + "\n");
                //
                 // \br.newLine();
                 BufferedReader in = new BufferedReader(new FileReader("filename.txt"));
                 String text = in.readLine();

                 in.close();
                 System.out.println(text);

             }

         } finally {
             br.close();
         }return getText();}
         /*Scanner scanner = new Scanner(new File("filename.txt"));
         while (scanner.hasNextLine()) {
             String line = scanner.nextLine();
             System.out.println(line);}}
              catch (IOException e) {
                 e.printStackTrace();*/
         }
    /*  FileReader file =new FileReader(file_name);
        String aryLines=file.OpenFile();
         int i;
         for(i=0;i<aryLines.length;i++){
             System.out.println(aryLines[i]);}}
    */



   /*  try {

         for (Double line : yourArray) {
             bw.write (line + "\n");
             bw.newLine();
         }

         BufferedReader in = new BufferedReader(new FileReader("filename.txt"));
         String text = in.readLine();
         in.close();
         double y = Double.parseDouble(text);
         System.out.println(text);


     } catch (IOException e) {
         e.printStackTrace();
     }
    // int content=0;
     //int x = Integer.parseInt(filename.txt);


     BufferedReader in = new BufferedReader(new FileReader("filename.txt"));
     String text = in.readLine();
     in.close();
     double y = Double.parseDouble(text);
     System.out.println(text);


}}
*/
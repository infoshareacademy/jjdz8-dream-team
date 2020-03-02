package com.infoshareacademy.ratings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WriteArray {
    public  ArrayList<Double> list(){
        return this.list();
    }

        public ArrayList<Double> value() throws IOException{
            try{
                BufferedReader br = new BufferedReader(new FileReader(new File("filename.txt")));
                ArrayList<Double> list = new ArrayList<Double>();

                String line;
                while((line=br.readLine())!=null){
                    String[] r = line.split(",");
                    for(int i=0; i<r.length; i++){
                        double val = Double.parseDouble(r[i]);
                        list.add(val);
                    }
                }br.close();
                System.out.println(list.size());
            }
            catch(IOException io){
                System.out.println("error");
            }


            return  list();
        }
    }









package com.infoshareacademy.ratings;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class DoubleConverte {
    public static void main(String[] args) {

    //jak dolozyc tu plik json6 i wyciagnac wszystkie dane
    String myJSONString = "{'test': '100.00'}";
    JsonObject jobj = new Gson().fromJson(myJSONString, JsonObject.class);

    double result = jobj.get("test").getAsDouble();
System.out.println(result);
}}

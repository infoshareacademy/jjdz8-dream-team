package com.infoshareacademy;

import com.infoshareacademy.menu.MenuService;

public class App {
    public static void main(String[] args) {
       MenuService service = new MenuService();
        service.appStart();
/*
        GetDataFromConsole getData=new GetDataFromConsole();
        getData.GetData();


        Teachers teachers = JsonReader.create(new Teachers(), FileNames.TEACHERS_JSON);
        for (Teacher teacher:teachers.getTeachers()) {
            StandardDeviation standard= new StandardDeviation();
            try {
                standard.StataRederJson(teacher);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        JsonSaver.createJson(teachers, FileNames.TEACHERS_JSON);
*/

    }



}
gi
package com.infoshareacademy;

import com.infoshareacademy.Kasia.GetDataFromConsole;
import com.infoshareacademy.Kasia.GsonExample;
import com.infoshareacademy.Kasia.StandardDeviation;
import com.infoshareacademy.Kasia.Student;
import com.infoshareacademy.menu.MenuService;

public class App {
    public static void main(String[] args) {
      /*  MenuService service = new MenuService();
        service.appStart();*/
        GetDataFromConsole getData=new GetDataFromConsole();
        getData.GetData();
        GsonExample gson3 =new GsonExample();
        gson3.studentWithGradesExample();

        StandardDeviation standard= new StandardDeviation();
        try {
            standard.StataRederJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
        double[] arr5 = new Student().getGrades() .stream().mapToDouble(Double::doubleValue).toArray();
    }



}

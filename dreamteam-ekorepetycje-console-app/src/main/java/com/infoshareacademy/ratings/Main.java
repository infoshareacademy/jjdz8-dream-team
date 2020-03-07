package com.infoshareacademy.ratings;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
         GsonExample gson3 =new GsonExample();
        gson3.studentWithGradesExample();
        //gson3.StataRederJson();
       StandardDeviation standard= new StandardDeviation();
       standard.StataRederJson();
        double[] arr5 = new Student().getGrades() .stream().mapToDouble(Double::doubleValue).toArray();

    }
}

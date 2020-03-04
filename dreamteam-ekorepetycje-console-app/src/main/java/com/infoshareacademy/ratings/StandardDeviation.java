package com.infoshareacademy.ratings;


import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StandardDeviation  {


    public static double max(double []a)
    {
        double max=Double.NEGATIVE_INFINITY;
        for (int i = 0; i <a.length ; i++)
            if(a[i]>max) max=a[i];
        return max;
    }

    public static double mean(double []a){
        double sum=0.0;
        for (int i = 0; i <a.length ; i++) {
            sum=sum+a[i];}
        return sum/a.length;
    }
    public static double var(double []a){
        double avg=mean(a);
        double sum=0.0;
        for (int i = 0; i <a.length ; i++) {
            sum+=(a[i]-avg)*(a[i]-avg);
        }
        return sum/(a.length-1);
    }

    public static double stddev(double []a){
        return  Math.sqrt(var(a));

    }

   public static long median(double[]a)
   {
       Arrays.sort(a);
       int middle = a.length / 2;
try{
       if (a.length % 2 == 0)

       {
           double left = a[middle - 1];
           double right = a[middle];

           return (long) ((left + right) / 2);}

       else{
           return (long) a[middle];}}
    catch (ArrayIndexOutOfBoundsException e){
    return 0;
}}
    static int mode(double a[]) {
        double maxValue = 0, maxCount = 0, i, j;

        for ( i = 0; i < a.length; ++i) {
            double count = 0;
            for (j = 0; j < a.length; ++j) {
                if (a[(int) j] == a[(int) i])
                    ++count;
            }

            if (count > maxCount) {
                maxCount = count;
                maxValue = a[(int) i];
            }
        }
        return (int) maxValue;
    }







    public static double skew (double [] data) {
        int i, n = data.length;


        double d, avg = 0.0;
        int count = 0;

        for (i=0; i<n; i++) {
            d = data [i];
            if (d != 0) {
                avg =  (avg+ d);
                count ++;
            }
        }

        if (count < 3)
            return 0;

        avg = avg / count;

        double stdev = 0.;
        for (i=0; i<n; i++) {
            d = data [i];
            if (d != 0) {
                d = d - avg;
                stdev = stdev + d * d;
            }
        }

        stdev = Math.sqrt (stdev / (count - 1));

        if (stdev == 0.)
            return 0;
        double skew = 0.;
        for (i=0; i<n; i++) {
            d = data [i];
            if (d != 0) {
                d = d - avg;
                d = d / stdev;
                skew = skew + d * d * d;
            }
        }

        return skew * count / ((count - 1) * (count - 2));
    }
    public static double kurt (double [] data) {
        int i, n = data.length;




        double d, avg = 0;
        int count = 0;

        for (i=0; i<n; i++) {
            d = data [i];
            if (d != 0) {
                avg =  (avg+d);
                count ++;
            }
        }

        if (count < 4)
            return 0;

        avg = avg / count;

        double stdev = 0.;
        for (i=0; i<n; i++) {
            d = data [i];
            if (d != 0) {
                d = d - avg;
                stdev = stdev + d * d;
            }
        }

        stdev = Math.sqrt (stdev / (count - 1));

        if (stdev == 0.)
            return 0;

        double kurt = 0.;
        for (i=0; i<n; i++) {
            d = data [i];
            if (d != 0) {
                d = d - avg;
                d = d / stdev;
                kurt = kurt + d * d * d * d;
            }
        }

        kurt = kurt * count * (count + 1) / (count - 1) - 3 * (count - 1) * (count - 1);
        return kurt / ((count - 2) * (count - 3));
    }
    public static <T> T createReader(T object, String fileName) {
        if (doNotExistAlready(fileName)) {
            return object;
        } else {
            Gson gson = new Gson();
            try {
                object = gson.fromJson(new FileReader(fileName), (Type) object.getClass());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return object;
    }public static boolean doNotExistAlready(String fileName) {
        File file = new File(fileName);

        return !file.exists() || file.length() == 0;
    }


    public StandardDeviation() {
    }

    public void StataRederJson(){
        Students studentsFromFile=createReader(new Students(),"studenci.json");
        for(Student s:studentsFromFile.getStudents()) {

            Student student = new Student("Kasia");
            if (
                    student.getName().equals("Kasia")) {

                List<Double> grades = new ArrayList<Double>();
                grades = s.getGrades();


                for (int i = 0; i < grades.size(); i++) {


                    double[] arr5 = grades.stream().mapToDouble(Double::doubleValue).toArray();
                }
                System.out.println("****************************");
                System.out.println("Nauczyciel o imieniu" +" "+ student.getName());
                //System.out.println("Tablica" + Arrays.toString(student.getArr5()));
                StandardDeviation standardDev = new StandardDeviation();
                standardDev.StataProgram(grades.stream().mapToDouble(Double::doubleValue).toArray());

                System.out.println("*************");

            }
            else {
                System.out.println("Nie znaleziono studenta o imieniu Kasia");

            }}}



    public void StataProgram( double arr5 []){


        System.out.println("wartosc najwieksza"+" "+max( (arr5)));

       System.out.println("wariancja"+" "+var(arr5));
        System.out.println("odchylenie standardowe"+" "+stddev(arr5));
       System.out.println("mediana"+" "+median(arr5));
        System.out.println("moda"+" "+mode(arr5));
        System.out.println("skosnosc"+" "+skew(arr5));
        System.out.println("kurtoza"+" "+kurt(arr5));


    int levelString=0;
        switch (levelString) {


            case 0:
                StandardDeviation.mean(arr5);
            {
                System.out.println("srednia arytemtyczna rozkladu oceniania"+" " + mean(arr5));
            }
       case 1:
                StandardDeviation.kurt(arr5);
            {

                if (kurt(arr5) == 0) {
                    System.out.println("rozkład normalny");
                }
                if(kurt(arr5)<0){
                System.out.println("rozkład platykurtyczny w zbiorze danych możemy zaobserwować większą liczbe wyników skrajnych ");}

            }
            if (kurt(arr5)>0){
                System.out.println("rozklad leptokurtyczn yw zbiorze danych możemy zaobserwować mniejsza liczbe wyników skrajnych ");

            }

        case 2:StandardDeviation.var(arr5);{
        if(var(arr5)==0){
        System.out.println(" Zadnego zroznicowania ocen wystawionych nauczycielowi.Wszystkie oceny badanych są jednakowe");
        }
        if(var(arr5)>3){
        System.out.println("Wynki są bardzo zroznicowane wsród badanych");
        }

        if(var(arr5)<3){
        System.out.println("Wynki są malo zroznicowane wsród badanych");
        }}



        case 3:StandardDeviation.max(arr5);{
        System.out.println("Najwyzsza wystawiona ocena"+max(arr5));

        }
        case 4:StandardDeviation.median(arr5);{
        System.out.println("Polowa ankietownaych ocenila nauczyciela powyzej"+" "+median(arr5)+" "+"Polowa ankietowanych ocenila wykladowce ponizej"+" "+median(arr5));
        }
        case 5:StandardDeviation.mode(arr5);{
        System.out.println("ocena występująca najczęściej "+mode(arr5));
        }
        case 6:StandardDeviation.skew(arr5);{
        if(skew(arr5)==0){System.out.println("rozklad symetryczny.Wszystkie osoby ocenialy wykladowce podobnie");
        break;
        }
        if(skew(arr5)<0) {System.out.println("rozkład ocen lewoskośny,Osoby oceniały wykładowce wysoko");
        break;
        }
        if(skew(arr5)>0) System.out.println("Rozkład ocen prawoskośny.Osoby oceniły wykładowcę nisko");
        }
        case 7:StandardDeviation.stddev(arr5);{
        if(stddev(arr5)<4.08){
        System.out.println("Bardzo duzy rozrzut odpowiedzi");
        }
        if(stddev(arr5)>4.08&&stddev(arr5)<=5.7){
        System.out.println("mało ocen zblizonych do sredniej oceny-duzy rozrzut odpowiedzi");}
        if(stddev(arr5)>5.7&&stddev(arr5)<=5.82){
        System.out.println("srednia ocen zblizonych do sredniej oceny-sredni  rozrzut odpowiedzi");}
        if(stddev(arr5)>5.82){
        System.out.println("duzo  ocen zblizonych do sredniej oceny-maly rozrzut odpowiedzi");}


        }
        }}
        }


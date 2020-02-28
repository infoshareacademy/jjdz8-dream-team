package com.infoshareacademy.ratings;


import java.util.Arrays;

public class StandardDeviation {

    public static double max(double[]a)
    {
    double max=Double.NEGATIVE_INFINITY;
        for (int i = 0; i <a.length ; i++)
        if(a[i]>max) max=a[i];
        return max;
    }

       public static double mean(double[]a){
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
        if (a.length % 2 == 0)
        {
            double left = a[middle - 1];
            double right = a[middle];
            return (long) ((left + right) / 2);
        }
        else
        {
            return (long) a[middle];
        }
    }
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




    public static void main(String[] args) {
        double a[]=new double[]{1.0,2.0,3.0,5.0,6.0,1.0,2.0,3.0,4.0,5.0,6.0,1.0,2.0,3.0,6.0,4.0,3.0,2.0};
        System.out.println("srednia"+" "+mean(a));
        System.out.println("wartosc najwieksza"+" "+max(a));
        System.out.println("wariancja"+" "+var(a));
        System.out.println("odchylenie standardowe"+" "+stddev(a));
        System.out.println("mediana"+" "+median(a));
        System.out.println("moda"+" "+mode(a));
        System.out.println("skosnosc"+" "+skew(a));
        System.out.println("kurtoza"+" "+kurt(a));


    int levelString=0;
        switch (levelString) {


            case 0:
                StandardDeviation.mean(a);
            {
                System.out.println("srednia arytemtyczna rozkladu oceniania"+" " + mean(a));
            }
            case 1:
                StandardDeviation.kurt(a);
            {

                if (kurt(a) == 0) {
                    System.out.println("rozkład normalny");
                }
                if(kurt(a)<0){
                System.out.println("rozkład platykurtyczny w zbiorze danych możemy zaobserwować większą liczbe wyników skrajnych ");}

            }
            if (kurt(a)>0){
                System.out.println("rozklad leptokurtyczn yw zbiorze danych możemy zaobserwować mniejsza liczbe wyników skrajnych ");

            }

            case 2:StandardDeviation.var(a);{
                if(var(a)==0){
                System.out.println(" Zadnego zroznicowania ocen wystawionych nauczycielowi.Wszystkie oceny badanych są jednakowe");
                }
                    if(var(a)>3){
                        System.out.println("Wynki są bardzo zroznicowane wsród badanych");
                    }

                    if(var(a)<3){
                        System.out.println("Wynki są malo zroznicowane wsród badanych");
                    }}



            case 3:StandardDeviation.max(a);{
                System.out.println("Najwyzsza wystawiona ocena"+max(a));

            }
            case 4:StandardDeviation.median(a);{
                System.out.println("Polowa ankietownaych ocenila nauczyciela powyzej"+" "+median(a)+" "+"Polowa ankietowanych ocenila wykladowce ponizej"+" "+median(a));
            }
            case 5:StandardDeviation.mode(a);{
                System.out.println("ocena występująca najczęściej "+mode(a));
            }
            case 6:StandardDeviation.skew(a);{
              if(skew(a)==0){System.out.println("rozklad symetryczny.Wszystkie osoby ocenialy wykladowce podobnie");
              break;
              }
              if(skew(a)<0) {System.out.println("rozkład ocen lewoskośny,Osoby oceniały wykładowce wysoko");
              break;
              }
             if(skew(a)>0) System.out.println("Rozkład ocen prawoskośny.Osoby oceniły wykładowcę nisko");
            }
            case 7:StandardDeviation.stddev(a);{
                if(stddev(a)<4.08){
                    System.out.println("Bardzo duzy rozrzut odpowiedzi");
                }
                if(stddev(a)>4.08&&stddev(a)<=5.7){
                    System.out.println("mało ocen zblizonych do sredniej oceny-duzy rozrzut odpowiedzi");}
                if(stddev(a)>5.7&&stddev(a)<=5.82){
                    System.out.println("srednia ocen zblizonych do sredniej oceny-sredni  rozrzut odpowiedzi");}
                if(stddev(a)>5.82){
                    System.out.println("duzo  ocen zblizonych do sredniej oceny-maly rozrzut odpowiedzi");}


            }
    }}
    }

package com.infoshareacademy;



public class Main {
    public static void main(String[] args) {
        int c=0,a,temp;
        int n=153;//It is the number to check armstrong
        temp=n;
        while(n>0)
        {
            a=n%10;
            System.out.println(a);
            n=n/10;
            System.out.println(n);
            c=c+(a*a*a);
            System.out.println(c);
        }
        if(temp==c)
            System.out.println("armstrong number");
        else
            System.out.println("Not armstrong number");
    }

}


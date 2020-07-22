package com.infoshareacademy;


import com.infoshareacademy.servlet.servletDao.SearchServlet;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculateTotalPages(10));
        System.out.println(calculateTotalPages(11));
        System.out.println(calculateTotalPages(5));
        System.out.println(calculateTotalPages(20));
        System.out.println(calculateTotalPages(25));
        System.out.println(calculateTotalPages(-5));
    }
    public static int calculateTotalPages(int subjectsListSize) {
        if (subjectsListSize < 10) return 1;
        if (subjectsListSize == 0) return 1;
        if (subjectsListSize % 10 != 0 ) return (subjectsListSize/10) +1;
        else return subjectsListSize/10;
    }
}


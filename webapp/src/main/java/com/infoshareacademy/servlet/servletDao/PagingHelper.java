package com.infoshareacademy.servlet.servletDao;

public class PagingHelper {

    public static double calculateTotalPages(Double totalItems, Double itemsForPage) {
        if (totalItems % 10 != 0) return (totalItems/10) +1;

        return totalItems/10;
    }
}

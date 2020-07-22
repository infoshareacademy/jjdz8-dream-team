package com.infoshareacademy.resolver;

import java.util.ArrayList;
import java.util.List;

public class PaginationHelper {

    public static int calculateOffset(int page, int limit) {
        if (page <= 0 || page == 1) return 0;
        return (page - 1) * limit;
    }

    public static int calculateTotalPages(int listSize) {
        if (listSize <= 0) return 0;
        if (listSize < 10) return 1;
        if (listSize % 10 != 0) return (listSize / 10) + 1;
        else return listSize / 10;
    }

    public static List<Integer> returnPageList(int totalPages) {
        List<Integer> result = new ArrayList<>();
        if (totalPages == 1) result.add(1);
        else {
            for (int i = 0; i <= totalPages; i++) {
                if (i!=0) result.add(i);
            }
        }
        return result;
    }
}

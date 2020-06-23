package com.infoshareacademy;

import com.infoshareacademy.fileOperations.SubjectColumn;
import com.infoshareacademy.fileOperations.SubjectQuery;
import com.infoshareacademy.repository.UserQuery;

public class Main {
    public static void main(String[] args) {
        System.out.println(SubjectQuery.FIND_BY_DESCRIPTION_QUERY);

        System.out.println(SubjectColumn.DESCRIPTION);

        String query = String.valueOf(UserQuery.FIND_BY_EMAIL_QUERY);

    }
}


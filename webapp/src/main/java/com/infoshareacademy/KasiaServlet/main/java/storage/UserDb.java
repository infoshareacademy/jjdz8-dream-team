package com.infoshareacademy.KasiaServlet.main.java.storage;


import com.infoshareacademy.KasiaServlet.main.java.domain.User;


import java.util.ArrayList;
import java.util.List;

public class UserDb {

  private static List<User> userRepository2= new ArrayList<>();

  public static List<User> getRepository() {
    if (userRepository2.size() == 0) {
      fillRepositoryWithDefaults();
    }
    return userRepository2;
  }

  private static void fillRepositoryWithDefaults() {

    User user1 = new User();
    user1.setId(1L);
    user1.setName("Jan");
    user1.setGrade(5);

    userRepository2.add(user1);

    User user2 = new User();
    user2.setId(2L);
    user2.setName("Adam");
    user2.setGrade(4);
    userRepository2.add(user2);

    User user3 = new User();
    user3.setId(3L);
    user3.setName("Anna");
    user3.setGrade(5);
    userRepository2.add(user3);
  }


  }

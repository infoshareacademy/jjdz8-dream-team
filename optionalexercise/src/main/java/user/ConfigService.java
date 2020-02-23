package user;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ConfigService {

    Map<String,String> config = new HashMap<>();

    public void readFile (String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //OPTIONAL
  /*   try {
            User user = fetchUser("Ania");
            System.out.println(user);
          //  System.out.println(user.getName());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
*/

     /*  Optional<User> user = fetchUser("Ola");

        User user1 = user.orElse(new User("DEfault User"));
        System.out.println(user1.getName());*/
/*
       if (user.isPresent()) {
           System.out.println(user.get().getName());
       }*/

      /*  Optional<User> user1 = Optional.of(new User("T"));
        Optional<User> user2 = Optional.empty();
        Optional<User> user3 = Optional.ofNullable(null);
     //  Optional<User> user4 = Optional.of(null);

        System.out.println(user1.get().getName());
        //System.out.println(user2.get().getName());


        if (user2.isPresent()) {
            System.out.println(user2.get().getName());
        }else {
            System.out.println("I'm sorry, there is no such user");
        }*/

      /*  public static Optional<User> fetchUser(String name) {
        if("Tomek".equals(name)){
            return Optional.of(new User("Tomek"));
        }

        return Optional.empty();
    }*/

}

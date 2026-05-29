package Service;

import Model.user;
import java.util.ArrayList;

public class userservice {

    private ArrayList<user> users = new ArrayList<>();
    private int userCounter = 1;

    public void register(String username, String password) {

        for (user user : users) {

            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists!");
                return;
            }
        }

        user user = new user(userCounter++, username, password);
        users.add(user);

        System.out.println("User registered successfully.");
    }

    public user login(String username, String password) {

        for (user user : users) {

            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {

                return user;
            }
        }

        return null;
    }
}
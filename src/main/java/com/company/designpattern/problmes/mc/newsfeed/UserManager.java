package com.company.designpattern.problmes.mc.newsfeed;

import java.util.*;
public class UserManager {
    private Map<String, User> userMap;

    public UserManager() {
        this.userMap = new HashMap<>();
    }

    public void registerUser(String name) throws Exception {
        if(userMap.containsKey(name))
            throw new Exception("User already exists");

        userMap.put(name, new User(name));
    }

    public User login(String name) throws Exception {
        if(!userMap.containsKey(name))
            throw new Exception("User doesnt exists");

        userMap.get(name).login();
        return userMap.get(name);
    }

    public void follow(User u1, User u2) throws Exception {
        if(!userMap.containsKey(u1.getName()) || !userMap.containsKey(u2.getName()) || !u1.isLoggedIn() || !u2.isLoggedIn()) {
            throw new Exception("One of the user doesnt exists | not logged in");
        }

        u1.follow(u2);
        u2.follow(u1);
    }


}

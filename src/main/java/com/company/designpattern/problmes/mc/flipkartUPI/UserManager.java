package com.company.designpattern.problmes.mc.flipkartUPI;

import java.util.*;

public class UserManager {
    Map<String, User> userMap;

    public UserManager() {
        this.userMap = new HashMap<>();
    }

    public User registerUser(String phone, String name) throws Exception{
        if(userMap.containsKey(phone))
            throw new Exception("Phone already linekd");

        User u = new User(phone,name);
        userMap.put(phone,u);
        return u;
    }

    public void markStatus(User user, UserStatus status) {
        user.setStatus(status);
    }
}

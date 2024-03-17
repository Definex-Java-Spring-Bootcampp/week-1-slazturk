package com.patika.kredinbizdenservice;

import java.util.*;

import com.patika.kredinbizdenservice.model.User;

//Class has been build according to singleton design pattern
public class UserManager {
	
	private static volatile UserManager instance;
	private List<User> users;

    private UserManager() {
        this.users = new ArrayList<>();
    }
    
    public static UserManager getInstance() {
    	if (instance == null) {
            synchronized (UserManager.class) {
                if (instance == null) {
                    instance = new UserManager();
                }
            }
        }
        return instance;
    }
    
    public boolean isEmailTaken(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void registerUser(User user) {
        if (!isEmailTaken(user.getEmail())) {
            users.add(user);
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Email already taken. Registration failed.");
        }
    }


}

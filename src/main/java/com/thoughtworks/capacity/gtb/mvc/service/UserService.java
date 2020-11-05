package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> userMap = new HashMap<>();
    private Integer idNow = 0;

    public User getUser(String username, String password) {
        if(userMap.containsKey(username)){
            User u = userMap.get(username);
            if(password.equals(u.getPassword())){
                return u;
            }else
                return null;
        }else {
            return null;
        }
    }

    public void registerUser(User user) {
        user.setId(idNow++);
        userMap.put(user.getUsername(), user);
        System.out.println(user);
    }
}

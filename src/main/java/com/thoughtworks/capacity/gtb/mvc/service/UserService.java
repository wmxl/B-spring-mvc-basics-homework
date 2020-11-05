package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.User;
import com.thoughtworks.capacity.gtb.mvc.excception.WrongPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> userMap = new HashMap<>();
    private Integer idNow = 0;

    public User getUser(String username, String password) {
        User u = userMap.get(username);
        if(u == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        if(!password.equals(u.getPassword())) {
            throw new WrongPasswordException("password wrong");     }
        return u;
    }

    public void registerUser(User user) {
        user.setId(idNow++);
        userMap.put(user.getUsername(), user);
        System.out.println(user);
    }
}

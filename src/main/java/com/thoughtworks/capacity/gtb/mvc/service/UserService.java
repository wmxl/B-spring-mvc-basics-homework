package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.User;
import com.thoughtworks.capacity.gtb.mvc.excception.UserExistException;
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
            // 这里故意留了一个框架自带的异常处理，没用自定义的，为了记住多种异常处理方式 ：）
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        if(!password.equals(u.getPassword()))
            throw new WrongPasswordException("password wrong");
        return u;
    }

    public void registerUser(User user) {
        if(userMap.containsKey(user.getUsername())){
            throw new UserExistException("user already exist");
        }

        user.setId(idNow++);
        userMap.put(user.getUsername(), user);

        System.out.println(user);
    }
}

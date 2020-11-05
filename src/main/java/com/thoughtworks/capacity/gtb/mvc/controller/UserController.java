package com.thoughtworks.capacity.gtb.mvc.controller;


import com.thoughtworks.capacity.gtb.mvc.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Validated
public class UserController {
    private Map<String, User> userMap = new HashMap<>();
    private Integer idNow = 0;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public User Login(@RequestParam String username, @RequestParam  String password) {
        if(userMap.containsKey(username)){
            return userMap.get(username);
        }else {
            return null;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void Register(@RequestBody @Valid User user) {
        user.setId(idNow++);
        userMap.put(user.getUsername(), user);
        System.out.println(user);
    }
}

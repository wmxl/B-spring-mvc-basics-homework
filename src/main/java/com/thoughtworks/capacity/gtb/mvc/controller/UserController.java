package com.thoughtworks.capacity.gtb.mvc.controller;


import com.thoughtworks.capacity.gtb.mvc.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    private Map<Integer, User> userMap = new HashMap<>();
    private Integer idNow = 0;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String Login() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void Register(@RequestBody User user) {
        user.setId(idNow);
        userMap.put(idNow++, user);
        System.out.println(user);
    }
}

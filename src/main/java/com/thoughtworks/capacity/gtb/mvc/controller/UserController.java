package com.thoughtworks.capacity.gtb.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String Login() {
        return "login";
    }
}

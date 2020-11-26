package com.sobuj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/user/")
    public String dashboard(){
        return "user/myacconut";
    }
}

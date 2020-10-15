package com.sobuj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
    @GetMapping("/list")
    public String listOfUser(){
        return "admin/user-list";
    }

    @GetMapping("/create")
    public String createUser(){
        return "admin/create-user";
    }
}

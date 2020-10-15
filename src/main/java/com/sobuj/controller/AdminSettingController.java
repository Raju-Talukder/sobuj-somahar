package com.sobuj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/setting")
public class AdminSettingController {
    @GetMapping("/profile")
    public String profile(){
        return "admin/profile";
    }
}

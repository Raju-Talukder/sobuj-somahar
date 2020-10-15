package com.sobuj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/vendor")
public class AdminVendorController {
    @GetMapping("/list")
    public String listOfVendor(){
        return "admin/list-vendor";
    }

    @GetMapping("/create")
    public String createVendor(){
        return "admin/create-vendors";
    }
}

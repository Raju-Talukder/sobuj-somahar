package com.sobuj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/coupon")
public class AdminCouponController {
    @GetMapping("/list")
    public String listOfCoupon(){
        return "admin/coupon-list";
    }
}

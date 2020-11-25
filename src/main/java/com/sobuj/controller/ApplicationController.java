package com.sobuj.controller;

import com.sobuj.dto.AccountCreateDto;
import com.sobuj.dto.VerifyAccountDto;
import com.sobuj.models.Account;
import com.sobuj.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ApplicationController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getName().equals("anonymousUser")){
            return "login/login";
        }
        return "redirect:/";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication.getName().equals("anonymousUser")){
//            return "login/register";
//        }
        model.addAttribute("accountCreateDto",new AccountCreateDto());
        return "login/register";
//        return "redirect:/";
    }

    @PostMapping("sign-up")
    public String signUp(@Valid AccountCreateDto accountCreateDto, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return "login/register";
        }
        Account account = accountService.registration(accountCreateDto);
        accountCreateDto.setId(account.getId());
        return "redirect:/verify-code";
    }

    @GetMapping("/verify-code")
    public String verifyCode(Model model, VerifyAccountDto codeVerifyDto) {
        model.addAttribute("codeVerifyDto",codeVerifyDto);
        return "login/verify-code";
    }

    @PostMapping("verify-code")
    public String verifyCodeAction(@Valid VerifyAccountDto codeVerifyDto, BindingResult result) {
        if(result.hasErrors()) {
            return "login/verify-code";
        }
        accountService.verifyCode(codeVerifyDto);
        return "redirect:/login";
    }
}

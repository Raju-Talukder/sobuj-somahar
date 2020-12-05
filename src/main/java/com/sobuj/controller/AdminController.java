package com.sobuj.controller;

import com.sobuj.dto.AccountUpdateDto;
import com.sobuj.models.Account;
import com.sobuj.models.Address;
import com.sobuj.service.account.AccountService;
import com.sobuj.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public String home(){
        return "admin/index";
    }

    @GetMapping("/profile")
    public String getProfile(Model model){
        accountService.getProfileInfo(model, accountService, addressService);
        return "admin/profile";
    }

    @GetMapping("/profile/edit")
    public String getEditProfile(Model model,AccountUpdateDto accountUpdateDto){
        accountService.showUserUpdateProfileFormData(model, accountUpdateDto, accountService, addressService);
        return "admin/editProfile";
    }

    @PostMapping("/profile/edit")
    public String editProfile(@RequestParam("image") MultipartFile image,@Valid AccountUpdateDto accountUpdateDto,
                              BindingResult result) throws Exception {
        if (result.hasErrors()){
            return "admin/editProfile";
        }
        accountService.updateAccount(image,accountUpdateDto);
        return "redirect:/admin/profile";
    }
}

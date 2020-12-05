package com.sobuj.controller;

import com.sobuj.dto.AccountUpdateDto;
import com.sobuj.service.account.AccountService;
import com.sobuj.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public String dashboard(Model model){
        return "user/myacconut";
    }

    @GetMapping("/orders")
    public String orderHistory(Model model){
        return "user/orders";
    }

    @GetMapping("/profile")
    public String getUserProfile(Model model){
        accountService.getProfileInfo(model, accountService, addressService);
        return "user/profile";
    }

    @GetMapping("/profile/edit")
    public String editUserProfile(Model model, AccountUpdateDto accountUpdateDto){
        accountService.showUserUpdateProfileFormData(model, accountUpdateDto, accountService, addressService);
        return "user/editProfile";
    }

    @PostMapping("/profile/edit")
    public String editProfile(@RequestParam("image") MultipartFile image, @Valid AccountUpdateDto accountUpdateDto,
                              BindingResult result) throws Exception {
        if (result.hasErrors()){
            return "user/editProfile";
        }
        accountService.updateAccount(image,accountUpdateDto);
        return "redirect:/user/profile";
    }
}

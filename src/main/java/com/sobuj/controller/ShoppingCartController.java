package com.sobuj.controller;

import com.sobuj.models.Account;
import com.sobuj.models.AddToCart;
import com.sobuj.models.ShoppingCart;
import com.sobuj.service.account.AccountService;
import com.sobuj.service.addToCart.AddToCartService;
import com.sobuj.service.shoppingCart.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AddToCartService addToCartService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    public String shoppingCart(Model model, Principal principal){
        Optional<Account> account = accountService.findByName(principal.getName());
        ShoppingCart shoppingCart = account.getShoppingCart();

        List<AddToCart> addToCart = addToCartService.findByShoppingCart(shoppingCart);
        shoppingCartService.updateShoppingCart(shoppingCart);

        model.addAttribute("addToCart", addToCart);
        model.addAttribute("shoppingCart", shoppingCart);
        return "shoppingCart";
    }
}

package com.sobuj.service.shoppingCart;

import com.sobuj.models.AddToCart;
import com.sobuj.models.ShoppingCart;
import com.sobuj.service.addToCart.AddToCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImp implements ShoppingCartService{

    @Autowired
    private AddToCartService addToCartService;

    public void updateShoppingCart(ShoppingCart shoppingCart){
        double[] cartTotal = new double[0];

        List<AddToCart> addToCartItem = addToCartService.findByShoppingCart(shoppingCart);

        for (AddToCart addToCart : addToCartItem){

        }
    }
}

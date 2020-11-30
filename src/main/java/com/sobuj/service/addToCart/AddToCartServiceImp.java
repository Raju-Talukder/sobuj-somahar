package com.sobuj.service.addToCart;

import com.sobuj.models.AddToCart;
import com.sobuj.models.ShoppingCart;
import com.sobuj.repository.AddToCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddToCartServiceImp implements AddToCartService{

    @Autowired
    private AddToCartRepository addToCartRepository;

    public List<AddToCart> findByShoppingCart(ShoppingCart shoppingCart){
        return addToCartRepository.findByShoppingCart(shoppingCart);
    }
}

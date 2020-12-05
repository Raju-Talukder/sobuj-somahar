package com.sobuj.service.addToCart;

import com.sobuj.models.AddToCart;
import com.sobuj.models.ShoppingCart;

import java.util.List;

public interface AddToCartService {
    List<AddToCart> findByShoppingCart(ShoppingCart shoppingCart);

    AddToCart updateAddToCart(AddToCart addToCart);
}

package com.sobuj.service.addToCart;

import com.sobuj.models.Account;
import com.sobuj.models.AddToCart;
import com.sobuj.models.Product;
import com.sobuj.models.ShoppingCart;

import java.util.List;

public interface AddToCartService {
    List<AddToCart> findByShoppingCart(ShoppingCart shoppingCart);

    AddToCart updateAddToCart(AddToCart addToCart);

    AddToCart addProductToAddToCart(Product product, Account account, int quantity);
}

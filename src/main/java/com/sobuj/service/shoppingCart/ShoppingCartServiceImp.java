package com.sobuj.service.shoppingCart;

import com.sobuj.models.AddToCart;
import com.sobuj.models.ShoppingCart;
import com.sobuj.repository.ShoppingCartRepository;
import com.sobuj.service.addToCart.AddToCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShoppingCartServiceImp implements ShoppingCartService{

    @Autowired
    private AddToCartService addToCartService;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart){
        BigDecimal cartTotal = new BigDecimal(0);

        List<AddToCart> addToCartItem = addToCartService.findByShoppingCart(shoppingCart);

        for (AddToCart addToCart : addToCartItem){
            if (addToCart.getProduct().getInStockNumber() > 0){
                addToCartService.updateAddToCart(addToCart);
                cartTotal = cartTotal.add(addToCart.getPrice());
            }
        }
        shoppingCart.setGrandTotal(cartTotal);
        shoppingCartRepository.save(shoppingCart);

        return shoppingCart;
    }
}

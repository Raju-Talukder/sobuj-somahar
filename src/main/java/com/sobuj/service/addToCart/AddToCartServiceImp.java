package com.sobuj.service.addToCart;

import com.sobuj.models.AddToCart;
import com.sobuj.models.ShoppingCart;
import com.sobuj.repository.AddToCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AddToCartServiceImp implements AddToCartService{

    @Autowired
    private AddToCartRepository addToCartRepository;

    public List<AddToCart> findByShoppingCart(ShoppingCart shoppingCart){
        return addToCartRepository.findByShoppingCart(shoppingCart);
    }

    public AddToCart updateAddToCart(AddToCart addToCart){
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(addToCart.getProduct().getPrice())).multiply(new BigDecimal(addToCart.getQuantity()));
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        addToCart.setPrice(bigDecimal);

        return addToCart;
    }
}

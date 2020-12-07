package com.sobuj.service.addToCart;

import com.sobuj.models.*;
import com.sobuj.repository.AddToCartRepository;
import com.sobuj.repository.ProductToCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AddToCartServiceImp implements AddToCartService{

    @Autowired
    private AddToCartRepository addToCartRepository;

    @Autowired
    private ProductToCartItemRepository productToCartItemRepository;


    public List<AddToCart> findByShoppingCart(ShoppingCart shoppingCart){
        return addToCartRepository.findByShoppingCart(shoppingCart);
    }

    public AddToCart updateAddToCart(AddToCart addToCart){
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(addToCart.getProduct().getPrice())).multiply(new BigDecimal(addToCart.getQuantity()));
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        addToCart.setPrice(bigDecimal);

        return addToCart;
    }

    public AddToCart addProductToAddToCart(Product product, Account account, int quantity){
        List<AddToCart> addToCartItem = findByShoppingCart(account.getShoppingCart());

        for (AddToCart addToCart : addToCartItem){
            if (product.getId() == addToCart.getProduct().getId()){
                addToCart.setQuantity(addToCart.getQuantity()+quantity);
                addToCart.setPrice(new BigDecimal(String.valueOf(product.getPrice())).multiply(new BigDecimal(quantity)));
                addToCartRepository.save(addToCart);
                return addToCart;
            }
        }
        AddToCart addToCart = new AddToCart();
        addToCart.setShoppingCart(account.getShoppingCart());
        addToCart.setProduct(product);
        addToCart.setQuantity(quantity);
        addToCart.setPrice(new BigDecimal(String.valueOf(product.getPrice())).multiply(new BigDecimal(quantity)));
        addToCart = addToCartRepository.save(addToCart);

        ProductToCartItem productToCartItem = new ProductToCartItem();
        productToCartItem.setProduct(product);
        productToCartItem.setAddToCart(addToCart);
        productToCartItemRepository.save(productToCartItem);

        return addToCart;
    }

}

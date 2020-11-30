package com.sobuj.repository;

import com.sobuj.models.AddToCart;
import com.sobuj.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddToCartRepository extends JpaRepository<AddToCart,Long> {
    List<AddToCart> findByShoppingCart(ShoppingCart shoppingCart);
}

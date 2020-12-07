package com.sobuj.repository;

import com.sobuj.models.ProductToCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductToCartItemRepository extends JpaRepository<ProductToCartItem, Long> {

}

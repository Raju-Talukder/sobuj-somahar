package com.sobuj.repository;

import com.sobuj.models.AddToCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddToCartRepository extends JpaRepository<AddToCart,Long> {
}

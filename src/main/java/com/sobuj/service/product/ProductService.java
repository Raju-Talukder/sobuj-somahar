package com.sobuj.service.product;

import com.sobuj.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findOne(Long id);
}

package com.sobuj.service.product;

import com.sobuj.models.Product;
import com.sobuj.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll(){
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findOne(Long id){
        return productRepository.findOne(id);
    }
}

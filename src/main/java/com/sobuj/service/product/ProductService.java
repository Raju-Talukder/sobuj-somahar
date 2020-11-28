package com.sobuj.service.product;

import com.sobuj.dto.ProductDto;
import com.sobuj.models.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(MultipartFile image, ProductDto product) throws IOException;
    Optional<Product> findById(Long id);
    List<Product> findAll();
    void deleteById(long entityId);
    void deleteProduct(Long id);
}

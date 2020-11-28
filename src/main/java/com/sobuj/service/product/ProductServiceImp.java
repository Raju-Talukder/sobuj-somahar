package com.sobuj.service.product;

import com.sobuj.dto.ProductDto;
import com.sobuj.models.Product;
import com.sobuj.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product createProduct(MultipartFile image, ProductDto product) throws IOException {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        String uploadDir = "./photos/products";
        ProductServiceImp.photoDuplicate(image, fileName, uploadDir);
        Product products = new Product();
        products.setName(product.getName());
        products.setCode(product.getCode());
        products.setPrice(product.getPrice());
        products.setDescription(product.getDescription());
        products.setPhoto(fileName);
        return productRepository.save(products);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(long entityId) {
        productRepository.deleteById(entityId);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    public static void photoDuplicate(MultipartFile image, String fileName, String uploadDir) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath))
            Files.createDirectories(uploadPath);
        try{
            InputStream inputStream = image.getInputStream();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new IOException("Not found");
        }
    }
}

package com.sobuj.controller;

import com.sobuj.dto.ProductDto;
import com.sobuj.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/add")
    public String addProduct(Model model, ProductDto productDto){
        model.addAttribute("productDto",productDto);
        return "admin/addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@Valid ProductDto productDto, MultipartFile image, BindingResult result) throws Exception{
        if (result.hasErrors()){
            return "admin/addProduct";
        }
        productService.createProduct(image,productDto);
        return "redirect:/admin/product/add";
    }

    @GetMapping("/category")
    public String category(){
        return "admin/category";
    }
}
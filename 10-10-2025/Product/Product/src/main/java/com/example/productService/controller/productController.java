package com.example.productService.controller;


import com.example.productService.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class productController {

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable String productId) {
        return new Product(productId, "Sample Product", 101.0);
    }
}

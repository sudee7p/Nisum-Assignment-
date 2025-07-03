package com.example.demo.controller;

import com.example.demo.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<Product> getAllProducts() {
        return List.of(
                new Product(1L, "Laptop", 999.99),
                new Product(2L, "Smartphone", 699.99)
        );
    }
}

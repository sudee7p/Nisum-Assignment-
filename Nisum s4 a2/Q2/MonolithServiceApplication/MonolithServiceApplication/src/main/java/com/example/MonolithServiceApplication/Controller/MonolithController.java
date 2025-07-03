package com.example.MonolithServiceApplication.Controller;

import com.example.MonolithServiceApplication.model.Product;
import com.example.MonolithServiceApplication.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonolithController {

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return new User(id, "Alice", "alice@example.com");
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return List.of(
                new Product(1L, "Monitor", 149.99),
                new Product(2L, "Keyboard", 39.99)
        );
    }
}

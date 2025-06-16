package com.example.demo.productAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private List<Product> productList = new ArrayList<>();

    // GET all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productList;
    }

    // GET product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST add a new product
    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productList.add(product);
        return ResponseEntity.ok("Product added successfully.");
    }

    // PUT update existing product
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.set(i, updatedProduct);
                return ResponseEntity.ok("Product updated successfully.");
            }
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        boolean removed = productList.removeIf(p -> p.getId() == id);
        if (removed) {
            return ResponseEntity.ok("Product deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package org.example.product;

import org.example.product.model.Product;
import org.example.product.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    private Product testProduct;

    @BeforeEach
    void setup() {
        repository.deleteAll();

        testProduct = new Product();
        testProduct.setName("Laptop");
        testProduct.setDescription("Gaming Laptop");
        testProduct.setPrice(85000);
        testProduct.setStockQuantity(10);
        testProduct.setCategory("Electronics");

        repository.save(testProduct);
    }

    @Test
    void testGetAllProducts() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Laptop")));
    }

    @Test
    void testGetProductById() throws Exception {
        mockMvc.perform(get("/products/" + testProduct.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Laptop")));
    }

    @Test
    void testCreateProduct() throws Exception {
        Product newProduct = new Product();
        newProduct.setName("Mouse");
        newProduct.setDescription("Wireless Mouse");
        newProduct.setPrice(1500);
        newProduct.setStockQuantity(50);
        newProduct.setCategory("Accessories");

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newProduct)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Mouse")));
    }

    @Test
    void testUpdateProduct() throws Exception {
        testProduct.setName("Updated Laptop");

        mockMvc.perform(put("/products/" + testProduct.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testProduct)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Updated Laptop")));
    }

    @Test
    void testDeleteProduct() throws Exception {
        mockMvc.perform(delete("/products/" + testProduct.getId()))
                .andExpect(status().isOk());

        mockMvc.perform(get("/products"))
                .andExpect(jsonPath("$", hasSize(0)));
    }
}

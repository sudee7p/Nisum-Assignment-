package com.example.Itest.model;

import jakarta.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;
    private Double amount;

    // Getters and setters
    public Order() {}
    public Order(String product, Double amount) {
        this.product = product;
        this.amount = amount;
    }

    // Getters & Setters
}

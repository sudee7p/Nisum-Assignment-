package com.example.OSS.controller;

import com.example.OSS.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    private static final String TOPIC = "order.created";

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        kafkaTemplate.send(TOPIC, order);
        return ResponseEntity.ok("Order placed successfully!");
    }
}

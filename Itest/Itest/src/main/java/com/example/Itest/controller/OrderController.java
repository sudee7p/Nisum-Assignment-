package com.example.Itest.controller;

import com.example.Itest.model.Order;
import com.example.Itest.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestParam String product, @RequestParam Double amount) {
        Order order = orderService.placeOrder(product, amount);
        return ResponseEntity.ok(order);
    }
}

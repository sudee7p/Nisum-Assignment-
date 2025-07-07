package com.example.Itest.service;

import com.example.Itest.model.Order;
import com.example.Itest.repository.OrderRepository;
import com.example.Itest.client.PaymentGatewayClient;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentGatewayClient paymentClient;

    public OrderService(OrderRepository orderRepository, PaymentGatewayClient paymentClient) {
        this.orderRepository = orderRepository;
        this.paymentClient = paymentClient;
    }

    public Order placeOrder(String product, Double amount) {
        if (paymentClient.processPayment(amount)) {
            return orderRepository.save(new Order(product, amount));
        } else {
            throw new RuntimeException("Payment failed");
        }
    }
}

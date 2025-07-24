package com.example.SS.listener;

import com.example.SS.model.Order;
import org.springframework.stereotype.Component;

@Component
public class ShippingListener {

    @KafkaListener(topics = "order.created", groupId = "shipping-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(Order order) {
        System.out.println("Shipping order: " + order.getOrderId());
        // Logic to reserve stock, update inventory, log confirmation
    }
}

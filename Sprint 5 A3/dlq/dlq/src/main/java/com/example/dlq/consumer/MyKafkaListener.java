package com.example.dlq.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaListener {

    @KafkaListener(topics = "input-topic", groupId = "my-consumer-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
        // Simulate failure
        if (message.contains("fail")) {
            throw new RuntimeException("Bad message encountered: " + message);
        }
    }
}


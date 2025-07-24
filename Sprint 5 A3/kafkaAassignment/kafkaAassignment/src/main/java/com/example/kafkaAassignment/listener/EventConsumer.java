package com.example.kafkaAassignment.listener;

import com.example.kafkaAassignment.model.UserEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EventConsumer {

    @KafkaListener(topics = "${topic.name}", groupId = "event_group")
    public void consume(UserEvent event) {
        System.out.println("Received Event: " + event);
    }
}

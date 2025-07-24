package com.example.kafkaAassignment.controller;

import com.example.kafkaAassignment.model.UserEvent;
import com.example.kafkaAassignment.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping
    public String publishEvent(@RequestBody UserEvent event) {
        producerService.sendMessage(event);
        return "Event published successfully";
    }
}

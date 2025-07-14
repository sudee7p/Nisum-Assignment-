package com.example.serviceA.controller;

import com.example.serviceA.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired private RestTemplate restTemplate;

    @GetMapping("/call-service-b")
    public String callServiceB() {
        String token = jwtUtil.generateToken("serviceA", "SERVICE_A");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8081/secure/data",
                HttpMethod.GET,
                entity,
                String.class
        );

        return "Response from Service B: " + response.getBody();
    }
}

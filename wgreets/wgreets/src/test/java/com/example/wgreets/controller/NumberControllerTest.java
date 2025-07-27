package com.example.wgreets.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(NumbersController.class)
public class NumberControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testNumbersStream() {
        webTestClient.get().uri("/numbers")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType("text/event-stream;charset=UTF-8")
                .expectBodyList(Integer.class)
                .hasSize(10);
    }
}

package com.example.Itest;

import com.example.Itest.client.PaymentGatewayClient;
import com.example.Itest.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private PaymentGatewayClient paymentGatewayClient;

	@Test
	void testCreateOrder_ReturnsSavedOrder() {
		// 1. Mock payment success
		when(paymentGatewayClient.processPayment(500.0)).thenReturn(true);

		// 2. Execute real HTTP call
		String url = "http://localhost:" + port + "/orders?product=Keyboard&amount=500";

		ResponseEntity<Order> response = restTemplate.postForEntity(url, null, Order.class);

		// 3. Verify response
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals("Keyboard", response.getBody().getProduct());
		assertEquals(500.0, response.getBody().getAmount());
	}
}

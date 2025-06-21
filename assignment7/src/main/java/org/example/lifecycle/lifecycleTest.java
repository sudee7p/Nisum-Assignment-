package org.example.lifecycle;

import org.junit.jupiter.api.*;

public class lifecycleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("➡️ @BeforeAll - Executed once before all tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("⏳ @BeforeEach - Executed before each test");
    }

    @Test
    void testOne() {
        System.out.println("✅ Test 1 is running");
    }

    @Test
    void testTwo() {
        System.out.println("✅ Test 2 is running");
    }

    @AfterEach
    void afterEach() {
        System.out.println("🔚 @AfterEach - Executed after each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("🧹 @AfterAll - Executed once after all tests");
    }
}
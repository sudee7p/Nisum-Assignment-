package org.example.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(10, calc.add(6, 4));
        assertNotEquals(11, calc.add(6, 4));
    }

    @Test
    void testSubtract() {
        assertEquals(2, calc.subtract(5, 3));
        assertNotEquals(1, calc.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(20, calc.multiply(4, 5));
        assertNotEquals(15, calc.multiply(4, 5));
    }

    @Test
    void testDivide() {
        assertEquals(3, calc.divide(9, 3));
        assertNotEquals(2, calc.divide(9, 3));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }
}
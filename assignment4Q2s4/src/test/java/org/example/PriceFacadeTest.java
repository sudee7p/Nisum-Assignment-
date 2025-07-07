package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PriceFacadeTest {

    @Spy
    private PriceCalculator calculatorSpy;

    private PriceFacade facade;

    @Before
    public void setUp() {
        // Replace actual calculator with spy
        facade = new PriceFacade() {
            @Override
            public double getPrice() {
                try {
                    return calculatorSpy.computePriceWithTax();
                } catch (ArithmeticException e) {
                    return 99.99;
                }
            }
        };
    }

    @Test
    public void testGetPrice_WithTaxException_ReturnsFallbackValue() throws Exception {
        // 3. Stub private method (via compute method) to throw exception
        doThrow(new ArithmeticException("Simulated error"))
                .when(calculatorSpy)
                .computePriceWithTax();

        double price = facade.getPrice();
        assertEquals(99.99, price, 0.001);
    }

    @Test
    public void testSpyReset_andRealMethodInvocation() {
        // 5. Reset the spy to remove stubbing
        reset(calculatorSpy);

        // Now it should call real method
        double actualPrice = facade.getPrice();
        assertEquals(120.0, actualPrice, 0.001); // 100 + 20
    }
}

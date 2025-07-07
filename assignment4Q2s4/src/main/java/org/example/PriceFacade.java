package org.example;

public class PriceFacade {

    private PriceCalculator calculator = new PriceCalculator();

    public double getPrice() {
        try {
            return calculator.computePriceWithTax();
        } catch (ArithmeticException e) {
            return 99.99; // fallback default value
        }
    }
}

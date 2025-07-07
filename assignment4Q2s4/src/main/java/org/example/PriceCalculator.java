package org.example;
public class PriceCalculator {

    public double getBasePrice() {
        return 100.0;
    }

    // Heavy private method
    private double calculateTax() {
        // simulate legacy logic
        return 20.0;
    }

    // This method internally uses calculateTax()
    public double computePriceWithTax() {
        return getBasePrice() + calculateTax();
    }
}

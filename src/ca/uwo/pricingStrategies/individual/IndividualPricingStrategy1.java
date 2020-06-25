package ca.uwo.pricingStrategies.individual;

/*
This strategy computes the price as the product of quantity and price
 */

public class IndividualPricingStrategy1 implements IndividualPricingStrategy{
    public double calculate(int quantity, double price) {
        return quantity * price;
    }
}

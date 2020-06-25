package ca.uwo.pricingStrategies.individual;

/*
This strategy add or reduce a 10% of the price computed as a product of quantity and price.
 */

public class IndividualPricingStrategy2 implements IndividualPricingStrategy{


    public double calculate(int quantity, double price) {
        return quantity * price * 0.9;
    }
}

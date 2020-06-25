package ca.uwo.pricingStrategies.individual;

/*
Default pricing strategy
 */

public class IndividualDefaultPricingStrategy implements  IndividualPricingStrategy {
    @Override
    public double calculate(int quantity, double price) {
        return quantity * price;
    }
}

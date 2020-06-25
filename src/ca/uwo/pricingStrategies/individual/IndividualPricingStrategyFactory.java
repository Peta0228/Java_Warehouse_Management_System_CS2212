package ca.uwo.pricingStrategies.individual;

/*
This is the factory in factory design pattern
 */

public class IndividualPricingStrategyFactory {

    public static IndividualPricingStrategy create(String type){
        switch(type) {
            case "test":
                return new TestIndividualPricingStrategy();
            default:
                return new IndividualDefaultPricingStrategy();
        }
    }
}

package ca.uwo.pricingStrategies.individual;

import ca.uwo.pricingStrategies.aggregate.AggregateDefaultPricingStrategy;
import ca.uwo.pricingStrategies.aggregate.TestAggregatePricingStrategy;

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

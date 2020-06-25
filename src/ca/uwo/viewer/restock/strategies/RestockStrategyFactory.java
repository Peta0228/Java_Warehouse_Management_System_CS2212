package ca.uwo.viewer.restock.strategies;

/*
This is a factory that generates RestockStrategy objects,
using the Factory design pattern.
It uses the method create to generate different types of RestockStrategy objects,
depending the parameter passed in the create method.
 */

public class RestockStrategyFactory {

    public static RestockStrategy create(String type) {
        switch(type) {
            case "weird":
                return new WeirdRestockStrategy();
            default:
                return new Units50RestockStrategy();
        }

    }

}

package ca.uwo.viewer.restock.strategies;

/*
This is a strategy that always restocks an item with 50 new units by
implementing the calculateQuantity method.
 */

public class Units50RestockStrategy implements RestockStrategy {
    public int calculateQuantity(String itemName, int quantity, double price) {
        return 50;
    }
}

package ca.uwo.viewer.restock.strategies;

/*
This strategy returns a number (say 50) as the quantity to restock
 */

public class RestockStrategy1 implements RestockStrategy {
    public int calculateQuantity(String itemName, int quantity, double price) {
        return 50;
    }
}

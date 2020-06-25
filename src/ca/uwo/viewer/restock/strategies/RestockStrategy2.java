package ca.uwo.viewer.restock.strategies;

/*
This strategy indicates that if the item is “apples” then rectock by 100 else restock by 25
 */

public class RestockStrategy2 implements RestockStrategy {
    public int calculateQuantity(String itemName, int quantity, double price) {
        if (itemName.equals("apples")){
            return 100;
        }
        return 25;
    }
}

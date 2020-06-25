package ca.uwo.viewer.restock.strategies;

/*
This is a strategy that always restocks apples with 500 new items,
otherwise with so many items as twice the product of remaining quantity+1 multiplied by the
unit price of the item!
 */


public class WeirdRestockStrategy implements RestockStrategy{
    public int calculateQuantity(String itemName, int quantity, double price) {
        if (itemName.equals("apple")){
            return 500;
        }

        // in case calculation returns overflow in java int
        return (int) Math.abs ((quantity * 2 + 1) * price);
    }
}

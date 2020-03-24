package ca.uwo.model.item.states;

/*
This class implements the Factory design pattern.
It provides a method create which uses the value of its parameter to create an object of type ItemState.
 */
public class ItemStateFactory {

    public static ItemState create(int quantity){

        // out of stock state
        if (quantity <= 0){
            return new OutOfStockState();
        }

        // low stock state
        else if (quantity < 10){
            return new LowStockState();
        }

        // in stock state
        else{
            return new InStockState();
        }
    }
}

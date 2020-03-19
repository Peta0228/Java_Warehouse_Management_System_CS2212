package ca.uwo.model.item.states;

public class ItemStateFactory {

    public static ItemState create(int quantity){
        if (quantity <= 0){
            return new OutOfStockState();
        }
        else if (quantity < 10){
            return new LowStockState();
        }
        else{
            return new InStockState();
        }
    }
}

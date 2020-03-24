package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

/*
This class provides the logic of the deplete and replenish methods,
when the item is considered as “in stock” (i.e. has available quantities in the warehouse).

 */
public class InStockState implements ItemState {

    /*
    depletion method
     */
    public ItemResult deplete(Item item, int quantity) {
        ItemResult itemResult;
        int availableQuantity = item.getAvailableQuantity();
        if (availableQuantity < quantity) {
            itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
        } else {
            availableQuantity -= quantity;
            itemResult = new ItemResult("AVAILABLE", ResponseCode.Completed);
        }

        item.setAvailableQuantity(availableQuantity);

        // notify viewers from the state
        item.notifyViewers();

        return itemResult;
    }

    /*
    replenish method
     */
    public ItemResult replenish(Item item, int quantity) {

        /*
        restock by the @quantity parameter
         */
        int availableQuantity = item.getAvailableQuantity();
        availableQuantity += quantity;
        item.setAvailableQuantity(availableQuantity);
        ItemResult itemResult = new ItemResult("RESTOCKED", ResponseCode.Completed);

        return itemResult;
    }
}

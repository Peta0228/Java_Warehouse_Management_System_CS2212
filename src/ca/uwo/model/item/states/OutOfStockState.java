package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

/*
Provides the logic of the deplete and replenish methods when the item is considered as “out of stock”
(i.e. the quantity of the available items is 0).
 */

public class OutOfStockState implements ItemState {

    /*
    depletion method
     */
    public ItemResult deplete(Item item, int quantity) {

        // depletion is not completed, when item is out of stock
        ItemResult itemResult;
        itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);

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

        return new ItemResult("RESTOCKED", ResponseCode.Completed);
    }
}

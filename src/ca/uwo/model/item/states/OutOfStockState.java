package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

public class OutOfStockState implements ItemState {
    public ItemResult deplete(Item item, int quantity) {
        ItemResult itemResult;
        itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);

        item.notifyViewers();

        return itemResult;
    }

    public ItemResult replenish(Item item, int quantity) {

        int availableQuantity = item.getAvailableQuantity();
        availableQuantity += quantity;
        item.setAvailableQuantity(availableQuantity);
        ItemResult itemResult = new ItemResult("RESTOCKED", ResponseCode.Completed);

        return itemResult;
    }
}

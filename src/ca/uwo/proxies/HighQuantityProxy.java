package ca.uwo.proxies;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

import java.util.Map;

public class HighQuantityProxy extends Proxy {
    @Override
    public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {

        // TODO: 2020/2/7 Authentication

        Facade facade = new Facade();
        facade.placeOrder(orderDetails, buyer);
    }

    @Override
    public void restock(Map<String, Integer> restockDetails, Supplier supplier) {

    }
}

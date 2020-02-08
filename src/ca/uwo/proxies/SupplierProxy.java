package ca.uwo.proxies;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;


import java.util.Map;

public class SupplierProxy extends Proxy {

    private static Proxy next = null;

    public SupplierProxy(){
        next = new LowQuantityProxy();
    }

    @Override
    public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
        next.placeOrder(orderDetails, buyer);

    }

    @Override
    public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
        Facade facade = new Facade();
        facade.restock(restockDetails, supplier);

        // TODO: 2020/2/7 restock method in Facade
    }
}

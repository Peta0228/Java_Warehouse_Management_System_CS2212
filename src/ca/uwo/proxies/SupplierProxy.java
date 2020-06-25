package ca.uwo.proxies;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;


import java.util.Map;

public class SupplierProxy extends Proxy {

    private static Proxy next = null;

    private static SupplierProxy instance = null;

    public static SupplierProxy getInstance(){
        if (instance == null){
            instance = new SupplierProxy();
        }
        return instance;
    }

    private SupplierProxy(){
        next = LowQuantityProxy.getInstance();
    }

    @Override
    public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
        next.placeOrder(orderDetails, buyer);

    }

    @Override
    public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
        Facade.getInstance().restock(restockDetails, supplier);

    }
}

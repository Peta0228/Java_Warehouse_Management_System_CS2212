package ca.uwo.proxies;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

import java.util.Map;
import java.util.stream.*;

public class LowQuantityProxy extends Proxy {

    private static Proxy next = null;

    public LowQuantityProxy(){ next  = new HighQuantityProxy(); }

    @Override
    public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {

        // TODO: 2020/2/7 : low/high quantity - conditions for high quality order
        orderDetails.values().toArray();
        int sum = 0;
        Object[] orderQuantities = orderDetails.values().toArray();
        for (Object orderQuantity : orderQuantities) {
            sum += (int) orderQuantity;
        }

        if (sum > 10){
            next.placeOrder(orderDetails, buyer);
        }
        else{
            // TODO: 2020/2/7 : authentication

            Facade facade = new Facade();
            facade.placeOrder(orderDetails, buyer);
        }
    }

    @Override
    public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
    }
}

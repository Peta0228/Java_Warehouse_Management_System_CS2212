package ca.uwo.proxies;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;

public class LowQuantityProxy extends Proxy {

    private static Proxy next = null;

    public LowQuantityProxy(){ next  = new HighQuantityProxy(); }

    @Override
    public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {


        /*
        Create credential database, segment copied from the Driver class
         */
        Map<Integer, Buyer> buyers = new HashMap<>();
        //Read all the buyers from the file and save them. Each line consists of the ID, name and password of the buyer.
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("buyer_file")));
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineTokens = line.split("\t");
                buyers.put(Integer.parseInt(lineTokens[0]), new Buyer(lineTokens[1], lineTokens[2]));
            }
            br.close();
        } catch (IOException ioe) {
            // TODO Auto-generated catch block
            ioe.printStackTrace();
        }


        /*
        Check the total quantities of order
         */
        orderDetails.values().toArray();
        int sum = 0;
        Object[] orderQuantities = orderDetails.values().toArray();
        for (Object perQuantity : orderQuantities) {
            sum += (int) perQuantity;
        }

        // Proceed to HighQuantityProxy if the sum of quantity is greater than 10
        if (sum > 10){
            next.placeOrder(orderDetails, buyer);
        }
        else{

            /*
            Authentication: username and password are stored in database
            */

            boolean authenticated = false;
            for (Buyer buyerInDatabase : buyers.values()) {
                if (buyerInDatabase.getUserName().equals(buyer.getUserName()) &&
                        buyerInDatabase.getPassword().equals(buyer.getPassword())){
                    System.out.println("Your order is handled by the high quantity order session.");
                    Facade.getInstance().placeOrder(orderDetails, buyer);
                    authenticated = true;
                }
            }

            // Inform users for invalid credentials
            if (!authenticated){
                System.out.println("Invalid Credentials");
            }
        }
    }

    @Override
    public void restock(Map<String, Integer> restockDetails, Supplier supplier) {}
}

package ca.uwo.frontend;

import java.util.Map;
import java.util.Map.Entry;

import ca.uwo.banking.BankingTransactions;
import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.controller.Controller;
import ca.uwo.frontend.interfaces.FacadeCommands;
import ca.uwo.utils.Invoice;
import ca.uwo.utils.Order;
import ca.uwo.utils.OrderItem;
import ca.uwo.dataAccess.DataManager;

/**
 * @author kkontog, ktsiouni, mgrigori
 * This class hides the complexities of the system by exposing only high level interfaces 
 * to the {@link ca.uwo.proxies.Proxy} class (using Facade design pattern), it utilizes operations in the 
 * {@link ca.uwo.controller.Controller} for the interface implementations.
 */
public class Facade implements FacadeCommands {
	private Controller controller;
	private BankingTransactions bank;
	
	/**
	 * constructor for Facade class.
	 */
	public Facade() {
		super();
		this.controller = new Controller();
		this.bank = new BankingTransactions();
	}
	
	/* (non-Javadoc)
	 * @see ca.uwo.frontend.interfaces.FacadeCommands#placeOrder(java.util.Map, ca.uwo.client.Buyer)
	 */
	@Override
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		//The buyer places the order according to orderDetails. The stock should be depleted
		//accordingly and the buyer needs to make the payment using the invoice.
		System.out.println("Facade: ");
		System.out.println("\tPlacing Order");

		// Placing Order
		Order myOrder = new Order();
		for (String s : orderDetails.keySet()) {
			OrderItem orderItem = new OrderItem(s, orderDetails.get(s));
			myOrder.addOrderItem(orderItem);
		}

		// Deplete stock
		controller.depleteStock(myOrder);

		System.out.println("\tCreating Invoice");

		// Create invoice for order
		// Receive payment from client
		bank.receivePayment(controller.createInvoice(), buyer);

	}
	
	/* (non-Javadoc)
	 * @see ca.uwo.frontend.interfaces.FacadeCommands#restock(java.util.Map, ca.uwo.client.Supplier)
	 */
	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
		//The supplier restock the supplies according to restockDetails. The stock should be 
		//replenished accordingly and the supplier need to get paid.
		System.out.println("Facade: ");

		// Create the order
		Order myOrder = new Order();
		for (String s : restockDetails.keySet()) {
			OrderItem orderItem = new OrderItem(s, restockDetails.get(s));
			myOrder.addOrderItem(orderItem);
		}

		System.out.println("\tReplenishing Stock");

		// Replenish stock according to order
		controller.replenishStock(myOrder);

		// Pay the supplier
		bank.paySupplier(supplier);

	}
	
	/**
	 * create an order according to the provided orderDetails.
	 * @param orderDetails the name and quantity of each item in the order.
	 * @param client the person who creates the order.
	 * @return the created order.
	 */
	private Order createOrder(Map<String, Integer> orderDetails, String client) {
		Order order = new Order();
		order.setClient(client);
		for (Entry<String,Integer> orderItem : orderDetails.entrySet()) {
			order.addOrderItem(new OrderItem(orderItem.getKey(), orderItem.getValue()));
		}
		
		return order;
	}

}
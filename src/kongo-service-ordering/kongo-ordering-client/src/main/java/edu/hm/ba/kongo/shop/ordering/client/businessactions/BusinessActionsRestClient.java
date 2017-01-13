package edu.hm.ba.kongo.shop.ordering.client.businessactions;


/**
 * Provides a simple Interface for the BusinessActions.
 */
public interface BusinessActionsRestClient {
	
	/**
	 * This BusinessAction's purpose is: Receives a shopping cart to create a new order which can then be payed
	 */
	void orderCart(String cartID);
	
	/**
	 * This BusinessAction's purpose is: Sends the value of the costs of the ordered procuts to an invoicing system
	 */
	void sendInvoice(String orderID);
	
	/**
	 * This BusinessAction's purpose is: Deletes an order and the associated shopping cart with it's contents
	 */
	void cancelOrder(String orderID);
}

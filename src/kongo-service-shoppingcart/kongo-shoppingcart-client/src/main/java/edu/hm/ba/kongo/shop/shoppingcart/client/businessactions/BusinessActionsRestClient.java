package edu.hm.ba.kongo.shop.shoppingcart.client.businessactions;


/**
 * Provides a simple Interface for the BusinessActions.
 */
public interface BusinessActionsRestClient {
	
	/**
	 * This BusinessAction's purpose is: Add a product from the warehouse to the users current shopping cart
	 */
	void addToCart(String productID, Long quantity);
}

package edu.hm.ba.kongo.shop.shoppingcart.guilib.gen.services;


/**
 * Provides a simple Service for the GUI to execute the BusinessActions.
 */
public interface BusinessActionsService {
	/**
	 * This BusinessAction's purpose is: Add a product from the warehouse to the users current shopping cart
	 */
	void addToCart(String productID, Long quantity);
	
}

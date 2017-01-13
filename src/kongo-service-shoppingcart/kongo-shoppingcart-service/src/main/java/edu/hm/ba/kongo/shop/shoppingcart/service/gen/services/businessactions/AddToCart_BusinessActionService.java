package edu.hm.ba.kongo.shop.shoppingcart.service.gen.services.businessactions;

import java.util.Map;


/**
 * Provides a service to execute business-actions.
 */
public interface AddToCart_BusinessActionService {
				
	/**
	 * This BusinessAction's purpose is: Add a product from the warehouse to the users current shopping cart
	 */
	void addToCart(Map<String, Object> header, String productID, Long quantity);
}

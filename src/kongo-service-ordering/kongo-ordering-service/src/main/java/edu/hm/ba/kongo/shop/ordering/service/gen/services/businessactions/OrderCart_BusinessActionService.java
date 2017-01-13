package edu.hm.ba.kongo.shop.ordering.service.gen.services.businessactions;

import java.util.Map;


/**
 * Provides a service to execute business-actions.
 */
public interface OrderCart_BusinessActionService {
				
	/**
	 * This BusinessAction's purpose is: Receives a shopping cart to create a new order which can then be payed
	 */
	void orderCart(Map<String, Object> header, String cartID);
}

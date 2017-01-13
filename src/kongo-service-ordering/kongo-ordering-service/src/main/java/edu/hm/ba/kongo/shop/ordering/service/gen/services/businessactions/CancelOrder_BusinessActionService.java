package edu.hm.ba.kongo.shop.ordering.service.gen.services.businessactions;

import java.util.Map;


/**
 * Provides a service to execute business-actions.
 */
public interface CancelOrder_BusinessActionService {
				
	/**
	 * This BusinessAction's purpose is: Deletes an order and the associated shopping cart with it's contents
	 */
	void cancelOrder(Map<String, Object> header, String orderID);
}

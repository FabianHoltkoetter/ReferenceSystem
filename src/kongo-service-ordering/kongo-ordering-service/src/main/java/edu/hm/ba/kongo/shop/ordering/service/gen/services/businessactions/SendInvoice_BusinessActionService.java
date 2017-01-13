package edu.hm.ba.kongo.shop.ordering.service.gen.services.businessactions;

import java.util.Map;


/**
 * Provides a service to execute business-actions.
 */
public interface SendInvoice_BusinessActionService {
				
	/**
	 * This BusinessAction's purpose is: Sends the value of the costs of the ordered procuts to an invoicing system
	 */
	void sendInvoice(Map<String, Object> header, String orderID);
}

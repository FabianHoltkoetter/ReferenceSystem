package edu.hm.ba.kongo.shop.ordering.client.businessactions;

import edu.hm.ba.kongo.shop.ordering.client.domain.OrderCart_BusinessActionParameters;
import edu.hm.ba.kongo.shop.ordering.client.domain.SendInvoice_BusinessActionParameters;
import edu.hm.ba.kongo.shop.ordering.client.domain.CancelOrder_BusinessActionParameters;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.DeserializationFeature;


/**
 * Provides a simple Implementation for executing BusinessActions on the Microservice.
 */
public class BusinessActionsRestClientImpl implements BusinessActionsRestClient {

	/** The relation on the base endpoint for the BusinessActions. */
	public static final String BUSINESS_ACTIONS = "businessActions";
	/** The restTemplate to do the REST Operations. */
	private final RestTemplate restTemplate;
	/** Tool used to traverse through the relations. */
	private final Traverson traverson;
	
	
	/**
	 * Mapper zum Uebersetzen der Json-Antwort in die entsprechende Objektstruktur
	 */
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * Create a new BusinessActionsRestClientImpl by RestTemplate of the server.
	 * @param restTemplate The restTemplate for the HTTP Requests.
	 */
	public BusinessActionsRestClientImpl(RestTemplate restTemplate, final URI basePath) {
		this.restTemplate = restTemplate;
		traverson = new Traverson(basePath, MediaTypes.HAL_JSON);
		traverson.setRestOperations(restTemplate);
		objectMapper.registerModule(new JavaTimeModule());
	}
	
		/**
		 * This BusinessAction's purpose is: Receives a shopping cart to create a new order which can then be payed
		 */
		@Override
		public void orderCart(String cartID){
			final OrderCart_BusinessActionParameters params = new OrderCart_BusinessActionParameters();
			params.setCartID(cartID);
			String link = getTraverson()
				.follow(BUSINESS_ACTIONS, "orderCart")
				.asLink().getHref();
			restTemplate.postForObject(link, params, Void.class);	
	}
		/**
		 * This BusinessAction's purpose is: Sends the value of the costs of the ordered procuts to an invoicing system
		 */
		@Override
		public void sendInvoice(String orderID){
			final SendInvoice_BusinessActionParameters params = new SendInvoice_BusinessActionParameters();
			params.setOrderID(orderID);
			String link = getTraverson()
				.follow(BUSINESS_ACTIONS, "sendInvoice")
				.asLink().getHref();
			restTemplate.postForObject(link, params, Void.class);	
	}
		/**
		 * This BusinessAction's purpose is: Deletes an order and the associated shopping cart with it's contents
		 */
		@Override
		public void cancelOrder(String orderID){
			final CancelOrder_BusinessActionParameters params = new CancelOrder_BusinessActionParameters();
			params.setOrderID(orderID);
			String link = getTraverson()
				.follow(BUSINESS_ACTIONS, "cancelOrder")
				.asLink().getHref();
			restTemplate.postForObject(link, params, Void.class);	
	}
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	
	public Traverson getTraverson() {
		return traverson;
	}
}

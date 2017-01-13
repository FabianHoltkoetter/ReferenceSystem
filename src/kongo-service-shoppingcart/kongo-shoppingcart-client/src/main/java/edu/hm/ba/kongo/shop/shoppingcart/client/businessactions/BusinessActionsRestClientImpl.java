package edu.hm.ba.kongo.shop.shoppingcart.client.businessactions;

import edu.hm.ba.kongo.shop.shoppingcart.client.domain.AddToCart_BusinessActionParameters;
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
		 * This BusinessAction's purpose is: Add a product from the warehouse to the users current shopping cart
		 */
		@Override
		public void addToCart(String productID, Long quantity){
			final AddToCart_BusinessActionParameters params = new AddToCart_BusinessActionParameters();
			params.setProductID(productID);
			params.setQuantity(quantity);
			String link = getTraverson()
				.follow(BUSINESS_ACTIONS, "addToCart")
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

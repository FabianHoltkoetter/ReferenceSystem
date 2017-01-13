package edu.hm.ba.kongo.shop.warehouse.client.businessactions;

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
	
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	
	public Traverson getTraverson() {
		return traverson;
	}
}

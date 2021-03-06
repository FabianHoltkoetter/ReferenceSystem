package edu.hm.ba.kongo.shop.ordering.client.rest;

import edu.hm.ba.kongo.shop.ordering.client.domain.OrderingItem_DTO;
import edu.hm.ba.kongo.shop.ordering.client.hateoas.OrderingItem_Assembler;
import edu.hm.ba.kongo.shop.ordering.client.local.OrderingItem_;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
public class OrderingItem_RestClientImpl implements OrderingItem_RestClient {
	
	public static final String FIND_FULL_TEXT_FUZZY = "findFullTextFuzzy";
	
	public static final String SEARCH = "search";
	
	/** Used to follow HATEOAS relations. */
    private final Traverson traverson;
    
    /** The restTemplate used for the HTTP Requests. */
    private final RestTemplate restTemplate;
    
    /** Assembler to switch from OrderingItem_DTO Resource to OrderingItem_ and vice versa. */
    private final OrderingItem_Assembler orderingItemAssembler = new OrderingItem_Assembler();
	
	/**
	 * Create a new OrderingItem_RestClient by RestTemplate of the server.
     * @param restTemplate The restTemplate for the HTTP Requests.
     * @param basePath The base URI of the REST Server.
     */
    public OrderingItem_RestClientImpl(RestTemplate restTemplate, final URI basePath) {
        this.restTemplate = restTemplate;
        traverson = new Traverson(basePath, MediaTypes.HAL_JSON);
        traverson.setRestOperations(restTemplate);
    }
	
	@Override
	public List<OrderingItem_> findFullTextFuzzy(String filter) {
		return traverson.follow(ORDERINGITEMS, SEARCH, FIND_FULL_TEXT_FUZZY)
				.withTemplateParameters(Collections.singletonMap("q", filter))
				.toObject(OrderingItem_Resource.LIST).getContent()
				.stream()
				.map(orderingItemAssembler::toBean)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<OrderingItem_> findAll() {  
		return traverson
				.follow(ORDERINGITEMS)
				.toObject(OrderingItem_Resource.LIST).getContent()
				
				.stream()
				.map(orderingItemAssembler::toBean)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<OrderingItem_> findAll(Link relation) {
		URI uri = URI.create(relation.getHref());
		return restTemplate
		 		.exchange(uri, HttpMethod.GET, null, OrderingItem_Resource.LIST)
		 		.getBody()
		 		.getContent()
		 		
		 		.stream()
		 		.map(orderingItemAssembler::toBean)
		 		.collect(Collectors.toList());
	}
		
	@Override
	public Optional<OrderingItem_> findOne(Link link) {
	     URI uri = URI.create(link.getHref());
	     
		OrderingItem_Resource resource;
		
		try {
			resource = restTemplate.exchange(uri, HttpMethod.GET, null, OrderingItem_Resource.class).getBody();
		} catch (HttpClientErrorException e) {
			final HttpStatus statusCode = e.getStatusCode();
			if (!HttpStatus.NOT_FOUND.equals(statusCode))
				throw e;
			if (Link.REL_SELF.equals(link.getRel()))
				throw e;
			return Optional.empty();
		}
		
		return Optional.of(orderingItemAssembler.toBean(resource));
	}
	
	@Override
	public void setRelations(Link endpoint, Collection<Link> links) {
		String relations = links.stream().map(Link::getHref).collect(Collectors.joining("\n"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "uri-list"));
		restTemplate.exchange(URI.create(endpoint.getHref()), HttpMethod.PUT, new HttpEntity<>(relations, headers), Void.class);
	}
	
	@Override
    public void setRelation(Link endpoint, Link relation) {
    	Optional<Link> rel = Optional.ofNullable(relation);
		if (rel.isPresent()) {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType("text", "uri-list"));
			restTemplate.exchange(URI.create(endpoint.getHref()), HttpMethod.PUT, new HttpEntity<>(rel.map(Link::getHref).get(), headers), Void.class);
		} else {
			this.delete(endpoint);
		}
    }

		
	@Override
	public OrderingItem_ create(OrderingItem_ orderingItem) {
		URI uri = URI.create(
		traverson.follow(ORDERINGITEMS).asLink().getHref());
			OrderingItem_DTO orderingItemDTO = orderingItemAssembler.toResource(orderingItem).getContent();
			OrderingItem_Resource resource = restTemplate.exchange(uri, HttpMethod.POST, new HttpEntity<>(orderingItemDTO), OrderingItem_Resource.class).getBody();
			return orderingItemAssembler.toBean(resource);
	}
	
	@Override
	public OrderingItem_ update(OrderingItem_ orderingItem) {

        URI uri = URI.create(orderingItem.getId().getHref());

        OrderingItem_DTO orderingItemDTO = orderingItemAssembler.toResource(orderingItem).getContent();

        OrderingItem_Resource resource = restTemplate.exchange(uri, HttpMethod.PUT, new HttpEntity<>(orderingItemDTO), OrderingItem_Resource.class).getBody();

        return orderingItemAssembler.toBean(resource);
    }
		
	@Override
	public void delete(Link id) {
		URI uri = URI.create(id.getHref());
		restTemplate.exchange(uri, HttpMethod.DELETE, null, Void.class);
	}
}

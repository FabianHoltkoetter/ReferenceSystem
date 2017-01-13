package edu.hm.ba.kongo.shop.shoppingcart.service.services.businessactions;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import edu.hm.ba.kongo.shop.shoppingcart.service.gen.services.businessactions.AddToCart_BusinessActionService;

/**
 * Provides a service to execute business-actions.
 * If used as generated by GAIA this service will be autowired and called by BusinessActionController.
 */
@Service
@PreAuthorize("hasAuthority('shoppingcart_BUSINESSACTION_AddToCart')")
public class AddToCart_BusinessActionServiceImpl implements AddToCart_BusinessActionService {
	// If you need access to the database you can autowire a Repository.
	// Repositories are generated into the package: .gen.rest
	//
	// @Autowired
	// <EntityName>Repository repo;

	/**
	 * This BusinessAction's purpose is: Add a product from the warehouse to the users current shopping cart
	 * TODO: Implement
	 */
	@Override
	public void addToCart(Map<String, Object> header, String productID, Long quantity){
		// Stop if parameters are null
		java.util.List<String> nullParams = new java.util.ArrayList<>();
		if(productID==null) nullParams.add("productID");
		if(quantity==null) nullParams.add("quantity");
		if(!nullParams.isEmpty()){
			throw new IllegalArgumentException("Expected values in body: String productID, Long quantity - Missing "+nullParams);
		}
		
		throw new UnsupportedOperationException("The BusinessAction addtocart is not yet implemented!");
	}
	
}
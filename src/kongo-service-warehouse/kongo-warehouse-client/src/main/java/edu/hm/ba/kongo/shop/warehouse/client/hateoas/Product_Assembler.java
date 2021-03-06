package edu.hm.ba.kongo.shop.warehouse.client.hateoas;

import edu.hm.ba.kongo.shop.warehouse.client.domain.Product_DTO;
import edu.hm.ba.kongo.shop.warehouse.client.local.Product_;
import edu.hm.ba.kongo.shop.warehouse.client.rest.Product_Resource;
import org.springframework.hateoas.Resource;
import java.util.UUID;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
public class Product_Assembler {


	/**
	 * Transform the Resource (from the REST Server) to the local object representation.
	 *
	 * @param resource the REST DTO Resource
	 * @return the local Object Representation
	 */
	public Product_ toBean(Resource<Product_DTO> resource) {
		Product_DTO productDTO = resource.getContent();
		Product_ bean = new Product_();		
		bean.setName(productDTO.getName());
		if(productDTO.getDescription() != null)
			bean.setDescription(productDTO.getDescription());
		bean.setPrice(productDTO.getPrice());
		bean.setQuantity(productDTO.getQuantity());
		bean.add(resource.getLinks());
		
		return bean;
	}
	
	/**
	 * Transform the local object representation to the DTO resource.
	 *
	 * @param bean the local object representation
	 * @return the REST DTO Resource
	 */
	public Product_Resource toResource(Product_ bean) {
		return new Product_Resource(toDTO(bean), bean.getLinks());
	}
	
	/**
	 * Transform the local object representation to the DTO.
	 *
	 * @param bean the local object representation
	 * @return the REST DTO
	 */
	public Product_DTO toDTO(Product_ bean) {
		Product_DTO productDTO = new Product_DTO();
		
		try{
			String[] id = bean.getId().getHref().split("/");
			productDTO.setOid(UUID.fromString(id[id.length-1]));
		} catch(Exception e) {/* No Link found */}
		
		productDTO.setName(bean.getName());
		if(bean.getDescription() != null)
			productDTO.setDescription(bean.getDescription());
		productDTO.setPrice(bean.getPrice());
		productDTO.setQuantity(bean.getQuantity());
		
		return productDTO;
	}
}

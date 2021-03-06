package edu.hm.ba.kongo.shop.ordering.client.hateoas;

import edu.hm.ba.kongo.shop.ordering.client.domain.OrderingItem_DTO;
import edu.hm.ba.kongo.shop.ordering.client.local.OrderingItem_;
import edu.hm.ba.kongo.shop.ordering.client.rest.OrderingItem_Resource;
import org.springframework.hateoas.Resource;
import java.util.UUID;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
public class OrderingItem_Assembler {


	/**
	 * Transform the Resource (from the REST Server) to the local object representation.
	 *
	 * @param resource the REST DTO Resource
	 * @return the local Object Representation
	 */
	public OrderingItem_ toBean(Resource<OrderingItem_DTO> resource) {
		OrderingItem_DTO orderingItemDTO = resource.getContent();
		OrderingItem_ bean = new OrderingItem_();		
		bean.setCart(orderingItemDTO.getCart());
		bean.setOrderedOn(orderingItemDTO.getOrderedOn());
		bean.add(resource.getLinks());
		
		return bean;
	}
	
	/**
	 * Transform the local object representation to the DTO resource.
	 *
	 * @param bean the local object representation
	 * @return the REST DTO Resource
	 */
	public OrderingItem_Resource toResource(OrderingItem_ bean) {
		return new OrderingItem_Resource(toDTO(bean), bean.getLinks());
	}
	
	/**
	 * Transform the local object representation to the DTO.
	 *
	 * @param bean the local object representation
	 * @return the REST DTO
	 */
	public OrderingItem_DTO toDTO(OrderingItem_ bean) {
		OrderingItem_DTO orderingItemDTO = new OrderingItem_DTO();
		
		try{
			String[] id = bean.getId().getHref().split("/");
			orderingItemDTO.setOid(UUID.fromString(id[id.length-1]));
		} catch(Exception e) {/* No Link found */}
		
		orderingItemDTO.setCart(bean.getCart());
		orderingItemDTO.setOrderedOn(bean.getOrderedOn());
		
		return orderingItemDTO;
	}
}

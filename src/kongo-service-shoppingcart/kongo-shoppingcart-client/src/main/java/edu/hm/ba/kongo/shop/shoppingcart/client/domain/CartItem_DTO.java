package edu.hm.ba.kongo.shop.shoppingcart.client.domain;

import de.muenchen.vaadin.demo.apilib.domain.BaseEntity;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
public class CartItem_DTO {
	
	private String product;
	
	private long quantity;
	
	// Getters and Setters
	public String getProduct(){
		return product;
	}
	public void setProduct(String product){
		this.product = product;
	}
	
	public long getQuantity(){
		return quantity;
	}
	public void setQuantity(long quantity){
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (this == other)
			return true;
		if (!(other.getClass() == CartItem_DTO.class))
			return false;
		CartItem_DTO cartItem_dto = (CartItem_DTO) other;
		if (getProduct() != null ? !getProduct().equals(cartItem_dto.getProduct()) : cartItem_dto.getProduct() != null)
			return false;
		if (getQuantity() != cartItem_dto.getQuantity())
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + (getProduct() != null ? getProduct().hashCode() : 0);
		result = 31 * result + (int) (getQuantity() ^ (getQuantity() >>> 32));
		return result;
	}

	@Override
	public String toString() {
	   	return String.format("%s = {\"product\": \"%s\", \"quantity\": \"%s\"}", getClass(),
	   		this.product,
	   		this.quantity);
	}
}

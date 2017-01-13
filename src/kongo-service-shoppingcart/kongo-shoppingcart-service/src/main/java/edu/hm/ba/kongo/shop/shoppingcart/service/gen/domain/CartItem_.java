package edu.hm.ba.kongo.shop.shoppingcart.service.gen.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;	
import javax.persistence.Embeddable;
import org.hibernate.search.annotations.Indexed;
import de.muenchen.service.BaseEntity;
import de.muenchen.auditing.MUCAudited;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
/**
 * This class represents a CartItem_.
 * <p>
 * Only oid and reference will be stored in the database.
 * The entity's content will be loaded according to the reference variable.
 * </p>
 */
@Embeddable
public class CartItem_ {
	
	// ========= //
	// Variables //
	// ========= //
	
	@Column(name="product")
	@NotNull
	@Size(max=24)
	private String product;
	
	
	@Column(name="quantity")
	@NotNull
	@Min((long)1.0)
	private long quantity;
	
	
	/**
	 * Default Constructor for CartItem.
	 */
	public CartItem_() {}
	
	// =================== //
	// Getters and Setters //
	// =================== //
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
		if (!(other.getClass() == CartItem_.class))
			return false;
		CartItem_ cartItem = (CartItem_) other;
		if (getProduct() != null ? !getProduct().equals(cartItem.getProduct()) : cartItem.getProduct() != null)
			return false;
		if (getQuantity() != cartItem.getQuantity())
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

	/**
	 * Returns a String representation for this CartItem.
	 * The form is:
	 * <EntityName>
	 * <attribute1_Type> <attribute1_name>: <attribute1_value>
	 * <attribute2_Type> <attribute2_name>: <attribute2_value>
	 * ...
	 */
	@Override
	public String toString(){
		String s = "CartItem";
		s += "\nString product: " + getProduct();
		s += "\nlong quantity: " + getQuantity();
		return s;
	}
}
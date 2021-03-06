package edu.hm.ba.kongo.shop.ordering.service.gen.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;	
import org.hibernate.search.annotations.Indexed;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Field;
import de.muenchen.service.BaseEntity;
import de.muenchen.service.PetersPerfectBridge;
import de.muenchen.vaadin.demo.apilib.domain.Past;
import de.muenchen.auditing.MUCAudited;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
/**
 * This class represents a OrderingItem_.
 * <p>
 * Only oid and reference will be stored in the database.
 * The entity's content will be loaded according to the reference variable.
 * </p>
 */
@Entity
@Indexed
@Table(name = "OrderingItem")
public class OrderingItem_ extends BaseEntity {
	
	// ========= //
	// Variables //
	// ========= //
	
	@Column(name="cart")
	@NotNull
	@Size(max=36)
	private String cart;
	
	
	@Column(name="orderedOn")
	@Field
	@FieldBridge(impl = PetersPerfectBridge.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@NotNull
	@Past
	private java.time.LocalDate orderedOn;
	
	
	/**
	 * Default Constructor for orderingItem.
	 */
	public OrderingItem_() {}
	
	// =================== //
	// Getters and Setters //
	// =================== //
	public String getCart(){
		return cart;
	}
	
	public void setCart(String cart){
		this.cart = cart;
	}
	
	
	public java.time.LocalDate getOrderedOn(){
		return orderedOn;
	}
	
	public void setOrderedOn(java.time.LocalDate orderedOn){
		this.orderedOn = orderedOn;
	}
	
	
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (this == other)
			return true;
		if (!(other.getClass() == this.getClass()))
			return false;
		if (!super.equals(other))
			return false;
		OrderingItem_ orderingItem = (OrderingItem_) other;
		if (getCart() != null ? !getCart().equals(orderingItem.getCart()) : orderingItem.getCart() != null)
			return false;
		if (!getOrderedOn().equals(orderingItem.getOrderedOn()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (getCart() != null ? getCart().hashCode() : 0);
		result = 31 * result + (getOrderedOn() != null ? getOrderedOn().hashCode() : 0);
		return result;
	}

	/**
	 * Returns a String representation for this orderingItem.
	 * The form is:
	 * <EntityName>
	 * <attribute1_Type> <attribute1_name>: <attribute1_value>
	 * <attribute2_Type> <attribute2_name>: <attribute2_value>
	 * ...
	 */
	@Override
	public String toString(){
		String s = "orderingItem";
		s += "\nString cart: " + getCart();
		s += "\njava.time.LocalDate orderedOn: " + getOrderedOn();
		return s;
	}
}

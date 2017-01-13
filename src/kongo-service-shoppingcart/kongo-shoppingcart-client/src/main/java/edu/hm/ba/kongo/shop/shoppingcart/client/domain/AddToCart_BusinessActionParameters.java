package edu.hm.ba.kongo.shop.shoppingcart.client.domain;


            public class AddToCart_BusinessActionParameters {
	private String productID;
	private Long quantity;

	public String getProductID(){return productID;}

	public void setProductID(String productID){this.productID = productID;}

	public Long getQuantity(){return quantity;}

	public void setQuantity(Long quantity){this.quantity = quantity;}

}

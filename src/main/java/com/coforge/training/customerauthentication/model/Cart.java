package com.coforge.training.customerauthentication.model;
/*
* Author : Pappula.Naidu
* Date   : 10-Dec-2024
* Time   : 8:30:04 pm
* Project: customer-authentication
*/
import jakarta.persistence.*;

@Entity
public class Cart {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long cartId;
   private String productName;
   private Double price;
   
   
   @OneToOne
   @JoinColumn(name = "customer_id")
   private Customer customer;
   
   
   
public Long getCartId() {
	return cartId;
}
public void setCartId(Long cartId) {
	this.cartId = cartId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
   
   
   
}
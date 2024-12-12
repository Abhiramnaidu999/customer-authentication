package com.coforge.training.customerauthentication.model;
/*
* Author : Pappula.Naidu
* Date   : 10-Dec-2024
* Time   : 8:29:52 pm
* Project: customer-authentication
*/

	
import jakarta.persistence.*;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Base64;


	@Entity
	public class Customer {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   
	   @Column(nullable = false, unique = true)
	   private String email;
	   private String firstname;
	   private String lastname;
	   
	   @Column(nullable = false)
	   private String password;
	   private LocalDate dob;
	   
	   @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	   private Cart cart;
	   
	   

	public Customer() {
		super();
	}

	

	public Customer(Long id, String email, String firstname, String lastname, String password, LocalDate dob,
			Cart cart) {
		super();
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.setPassword(password);
		this.dob = dob;
		this.cart = cart;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
	    Base64.Encoder encoder = Base64.getEncoder();  
	    String encodedString = encoder.encodeToString(password.getBytes(StandardCharsets.UTF_8));
	    this.password = encodedString; 
	}




	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public Cart getCart() {
		return cart;
	}



	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
	
	   
	   
	  

	

	}





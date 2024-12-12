package com.coforge.training.customerauthentication.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Author : Pappula.Naidu
* Date   : 11-Dec-2024
* Time   : 7:21:46 pm
* Project: customer-authentication
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.customerauthentication.exception.ResourceNotFoundException;
import com.coforge.training.customerauthentication.model.Customer;
import com.coforge.training.customerauthentication.service.CustomerService;
@RestController
@RequestMapping("/api")
public class CustomerController {
   @Autowired
   private CustomerService cservice;
   public CustomerController(CustomerService cservice) {
		super();
		this.cservice = cservice;
	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(@Validated @RequestBody Customer customer){
		
		try {
			Customer c=cservice.saveCustomer(customer);
			return ResponseEntity.status(HttpStatus.CREATED).body(c);
		}
		catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		try {
			List<Customer> customer=cservice.listAll();
			return ResponseEntity.ok(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@GetMapping("/customers/{cid}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "cid") Long cId) throws ResourceNotFoundException{
		
		Customer c=cservice.getSingleCustomer(cId).orElseThrow(()->new ResourceNotFoundException("Product not found with this ID:"+cId));
		return ResponseEntity.ok(c);
	}
	
	@PutMapping("/customers/{cid}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "cid") Long cId,@Validated @RequestBody Customer c) throws ResourceNotFoundException{
		Customer customer=cservice.getSingleCustomer(cId).orElseThrow(()->new ResourceNotFoundException("Product not found with this ID:"+cId));
		
		//update product with new values
		customer.setFirstname(c.getFirstname());
		customer.setLastname(c.getLastname());
		customer.setEmail(c.getEmail());
		customer.setDob(c.getDob());
		
		final Customer updateCustomer=cservice.saveCustomer(customer);
		return ResponseEntity.ok().body(updateCustomer);
		
	}
	
	@DeleteMapping("/customers/{cid}")
	public ResponseEntity<Map<String,Boolean>> deleteCustomer(@PathVariable(value = "cid") Long cId) throws ResourceNotFoundException{
		
		//invokes service layer method
		cservice.getSingleCustomer(cId).orElseThrow(()->new ResourceNotFoundException("customer not found with this ID:"+cId));
		
		cservice.deleteProduct(cId);  //invokes service layer method
		
		Map<String,Boolean> response=new HashMap<>(); //map stores data in key value pair
		response.put("Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
}

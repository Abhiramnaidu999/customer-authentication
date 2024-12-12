package com.coforge.training.customerauthentication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.training.customerauthentication.model.Customer;
import com.coforge.training.customerauthentication.repository.CustomerRepository;

/*
* Author : Pappula.Naidu
* Date   : 11-Dec-2024
* Time   : 7:15:50 pm
* Project: customer-authentication
*/
@Service
public class CustomerService {

	@Autowired
	   private CustomerRepository crepo;
	//constructor injection
		public CustomerService(CustomerRepository crepo) {
			this.crepo=crepo;
		}
	 
		public Customer saveCustomer(Customer c) {
	 
			return crepo.save(c); //invokes pre-defined method save() of JPA repository
		}
		public List<Customer> listAll(){
			return crepo.findAll(); //invokes pre-defined method findAll() of JPA repository
		}
		//optional return type is to handle null pointer exception
		public Optional<Customer> getSingleCustomer(long cid){
			return crepo.findById(cid);  //invokes pre-defined method findById() of JPA repository
		}
	 
		public void deleteProduct(long cid) {
			crepo.deleteById(cid); //invokes pre-defined method deleteById() of JPA repository
		}
//		public  List<Customer> searchProductByName(String name){
//			return  crepo.findProductByNameContainingIgnoreCase(name);
//		}
	   
}



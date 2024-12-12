package com.coforge.training.customerauthentication.repository;
/*
* Author : Pappula.Naidu
* Date   : 10-Dec-2024
* Time   : 8:39:09 pm
* Project: customer-authentication
*/
import org.springframework.data.jpa.repository.JpaRepository;
import com.coforge.training.customerauthentication.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
   
}

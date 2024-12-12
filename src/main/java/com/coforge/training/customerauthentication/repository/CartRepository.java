package com.coforge.training.customerauthentication.repository;
/*
* Author : Pappula.Naidu
* Date   : 10-Dec-2024
* Time   : 8:39:28 pm
* Project: customer-authentication
*/
import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.customerauthentication.model.Cart;


public interface CartRepository extends JpaRepository<Cart, Long> {
}

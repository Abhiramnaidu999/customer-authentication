package com.coforge.training.customerauthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
* Author : Pappula.Naidu
* Date   : 12-Dec-2024
* Time   : 9:20:17 am
* Project: customer-authentication
*/
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
		
	}


}

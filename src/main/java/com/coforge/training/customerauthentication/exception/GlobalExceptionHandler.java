package com.coforge.training.customerauthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;



/*
* Author : Pappula.Naidu
* Date   : 12-Dec-2024
* Time   : 9:19:28 am
* Project: customer-authentication
*/
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
   // 	logger.error("Resource not found: {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	

}

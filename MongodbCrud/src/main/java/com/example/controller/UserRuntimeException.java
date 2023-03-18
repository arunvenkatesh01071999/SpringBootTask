package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 424999170800636847L;

	public UserRuntimeException(String message) {
		super(message);
	}

	
}

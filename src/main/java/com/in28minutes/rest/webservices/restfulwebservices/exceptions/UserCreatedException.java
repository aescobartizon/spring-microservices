package com.in28minutes.rest.webservices.restfulwebservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserCreatedException extends RuntimeException {

	public UserCreatedException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1214640253046328152L;

}

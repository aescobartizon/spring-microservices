package com.in28minutes.rest.webservices.restfulwebservices.exceptions;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExceptionResponse {
	
	private Date timestamp;
	
	private String message;
	
	private String details;

}

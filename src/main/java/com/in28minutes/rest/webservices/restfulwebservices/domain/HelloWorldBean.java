package com.in28minutes.rest.webservices.restfulwebservices.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HelloWorldBean implements Serializable{

	private String message;
	
	private static final long serialVersionUID = 1998148761508184393L;

}

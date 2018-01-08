package com.in28minutes.rest.webservices.restfulwebservices.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Name implements Serializable{

	private static final long serialVersionUID = 1L;

	private String firstName;
	
	private String lastName;

}

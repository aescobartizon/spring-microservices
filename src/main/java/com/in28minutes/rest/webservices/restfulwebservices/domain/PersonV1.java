package com.in28minutes.rest.webservices.restfulwebservices.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PersonV1 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;

}

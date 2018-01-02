package com.in28minutes.rest.webservices.restfulwebservices.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User implements Serializable{

	private static final long serialVersionUID = -5659121145198600763L;
	
	private Integer id;
	
	private String name;
	
	private Date birthDate;

}

package com.in28minutes.rest.webservices.restfulwebservices.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SomeBean implements Serializable{

	private static final long serialVersionUID = -4655081468817597310L;
	
	private String field1;
	
	private String field2;
	
	@JsonIgnore
	private String field3;

}

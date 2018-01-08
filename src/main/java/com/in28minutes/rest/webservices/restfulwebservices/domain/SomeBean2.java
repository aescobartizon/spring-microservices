package com.in28minutes.rest.webservices.restfulwebservices.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonFilter("SomeBean2Filter")
public class SomeBean2 implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String field1;
	
	private String field2;
	
	private String field3;
	
}

package com.in28minutes.rest.webservices.restfulwebservices.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@ApiModel(description="All details about user.")
public class User implements Serializable{

	private static final long serialVersionUID = -5659121145198600763L;
	
	private Integer id;
	
	@Size(min=2, message = "Name should have atleast 2 characters")
	@NotNull
	@ApiModelProperty(notes = "Lenght sould be unless 1")
	private String name;
	
	@Past
	@NotNull
	@ApiModelProperty(notes = "Birth date should be in the past")
	private Date birthDate;

}

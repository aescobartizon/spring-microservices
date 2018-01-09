package com.in28minutes.rest.webservices.restfulwebservices.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description="All details about user.")
@Entity
public class User implements Serializable{

	public User() {
		super();
	}

	public User(Integer id, @Size(min = 2, message = "Name should have atleast 2 characters") @NotNull String name,
			@Past @NotNull Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	private static final long serialVersionUID = -5659121145198600763L;



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
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

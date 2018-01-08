package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.domain.Name;
import com.in28minutes.rest.webservices.restfulwebservices.domain.PersonV1;
import com.in28minutes.rest.webservices.restfulwebservices.domain.PersonV2;

@RestController
public class PersonVersioningController {

	private static final String PERSON_END_POINT_V1 = "v1/person";
	
	private static final String PERSON_END_POINT_V2 = "v2/person";
	
	@GetMapping(path=PERSON_END_POINT_V1)
	public PersonV1 retrievePersonV1() {
		return PersonV1.builder().name("Antonio Escobar").build();
	}
	
	@GetMapping(path=PERSON_END_POINT_V2)
	public PersonV2 retrievePersonV2() {
		return PersonV2.builder().name(Name.builder().firstName("Antonio").lastName("Escobar").build()).build();
	}
}

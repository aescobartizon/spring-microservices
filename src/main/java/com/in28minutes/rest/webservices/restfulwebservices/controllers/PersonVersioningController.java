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
	
	private static final String PERSON_END_POINT_HEADER = "/person/header";
	
	private static final String PERSON_END_POINT_PRODUCER = "/person/producer";

	
	@GetMapping(path=PERSON_END_POINT_V1)
	public PersonV1 retrievePersonV1() {
		return PersonV1.builder().name("Antonio Escobar").build();
	}
	
	@GetMapping(path=PERSON_END_POINT_V2)
	public PersonV2 retrievePersonV2() {
		return PersonV2.builder().name(Name.builder().firstName("Antonio").lastName("Escobar").build()).build();
	}
	
	@GetMapping(value=PERSON_END_POINT_HEADER, headers = "X-API-VERSION=1")
	public PersonV1 retrievePersonHeader1() {
		
		return PersonV1.builder().name("Antonio Escobar").build();
	}
	
	
	@GetMapping(value=PERSON_END_POINT_HEADER,headers = "X-API-VERSION=2")
	public PersonV2 retrievePersonHeader2() {
		return PersonV2.builder().name(Name.builder().firstName("Antonio").lastName("Escobar").build()).build();
	}
	
	@GetMapping(value=PERSON_END_POINT_PRODUCER, produces="application/vnd.company.app-v1+json")
	public PersonV1 retrieveProducerV1() {
		return PersonV1.builder().name("Antonio Escobar").build();
	}
	
	@GetMapping(value=PERSON_END_POINT_PRODUCER,produces="application/vnd.company.app-v2+json")
	public PersonV2 retrieveProducerV2() {
		return PersonV2.builder().name(Name.builder().firstName("Antonio").lastName("Escobar").build()).build();
	}
}

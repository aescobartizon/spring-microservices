package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.domain.SomeBean;
import com.in28minutes.rest.webservices.restfulwebservices.domain.SomeBean2;

@RestController
public class FilteringController extends AbstractRestApiController{
	
	private static final String FILTERING_END_POINT = "/filtering";
	
	private static final String FILTERING_LIST_END_POINT = "/filtering-list";
	
	private static final String FILTERING_DINAMIC1_END_POINT = "/filtering-dinamic1";
	
	private static final String FILTERING_DINAMIC2_END_POINT = "/filtering-dinamic2";
	
	private static final String  FIELD1_VALUE = "field1";
	
	private static final String  FIELD2_VALUE = "field2";
	
	private static final String  FIELD3_VALUE = "field3";
	
	@GetMapping(path = FILTERING_END_POINT)
	public SomeBean retriveSomeBean() {
		return SomeBean.builder().field1(FIELD1_VALUE).field2(FIELD2_VALUE).field3(FIELD3_VALUE).build();
	}
	
	@GetMapping(path = FILTERING_LIST_END_POINT)
	public List<SomeBean> retriveListSomeBean() {
		return Arrays.asList(
				SomeBean.builder().field1(FIELD1_VALUE).field2(FIELD2_VALUE).field3(FIELD3_VALUE).build(),
				SomeBean.builder().field1(FIELD1_VALUE).field2(FIELD2_VALUE).field3(FIELD3_VALUE).build(),
				SomeBean.builder().field1(FIELD1_VALUE).field2(FIELD2_VALUE).field3(FIELD3_VALUE).build());
	}
	
	@GetMapping(path = FILTERING_DINAMIC1_END_POINT)
	public MappingJacksonValue retriveSomeBeanDinamic1() {
		return filteringRequest(new HashSet<>(Arrays.asList("field3")),
				SomeBean2.builder().field1(FIELD1_VALUE).field2(FIELD2_VALUE).field3(FIELD3_VALUE).build(),
				"SomeBean2Filter");
	}
	
	@GetMapping(path = FILTERING_DINAMIC2_END_POINT)
	public MappingJacksonValue retriveSomeBeanDinamic2() {
		
		return filteringRequest(new HashSet<>(Arrays.asList("field2")), Arrays.asList(
				SomeBean2.builder().field1(FIELD1_VALUE).field2(FIELD2_VALUE).field3(FIELD3_VALUE).build(),
				SomeBean2.builder().field1(FIELD1_VALUE).field2(FIELD2_VALUE).field3(FIELD3_VALUE).build(),
				SomeBean2.builder().field1(FIELD1_VALUE).field2(FIELD2_VALUE).field3(FIELD3_VALUE).build()), "SomeBean2Filter");
		
	}
	
}

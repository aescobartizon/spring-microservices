package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class AbstractRestApiController {

	public MappingJacksonValue filteringRequest(Set<String> fields, Object value, String filterName) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept(fields);
		FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, filter);
		MappingJacksonValue mapping = new MappingJacksonValue(value);
		mapping.setFilters(filters);
		return mapping;
	}

}

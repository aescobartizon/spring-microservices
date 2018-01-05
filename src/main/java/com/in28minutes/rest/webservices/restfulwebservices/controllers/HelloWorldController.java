package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.domain.HelloWorldBean;

import lombok.Getter;
import lombok.Setter;

@RestController
public class HelloWorldController {
	
	private static String helloWorld = "hello world";
	
	@Autowired
	@Getter
	@Setter
	private MessageSource messageSource;

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return helloWorld; 
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return HelloWorldBean.builder().message(helloWorld).build();
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return HelloWorldBean.builder().message(String.format("Hello World, %s", name)).build();
	}
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
		return getMessageSource().getMessage("good.morning.message", null, locale);
	}
}

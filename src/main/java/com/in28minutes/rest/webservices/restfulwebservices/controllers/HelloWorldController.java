package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.domain.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	private static String helloWorld = "hello world";

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
}

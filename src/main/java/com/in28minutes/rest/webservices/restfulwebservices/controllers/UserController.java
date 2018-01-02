package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.domain.User;
import com.in28minutes.rest.webservices.restfulwebservices.services.UserService;

@RestController
public class UserController {
	
	 @Autowired
	 UserService userService;
	 
	 @GetMapping(path = "/users")
	 public List<User> retrieveAllUsers(){
		 return userService.findAll();
	 }
	 
	 @GetMapping(path = "/users/{id}")
	 public User retrieveUser(@PathVariable int id) {
		 return userService.findOne(id);
	 }

}

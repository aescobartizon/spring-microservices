package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.domain.User;
import com.in28minutes.rest.webservices.restfulwebservices.facades.UsersFacade;

@RestController
public class UserController {
	
	private static final String USERS_END_POINT = "/users";
	
	 @Autowired
	 UsersFacade usersFacade;
	 
	 @GetMapping(path = USERS_END_POINT)
	 public List<User> retrieveAllUsers(){
		 return usersFacade.findAll();
	 }
	 
	 @GetMapping(path = USERS_END_POINT+"/{id}")
	 public User retrieveUser(@PathVariable int id) {
		 
		 return usersFacade.findOne(id);
	 }

	 @PostMapping(path = USERS_END_POINT)
	 public ResponseEntity<Object> createUser(@RequestBody User user) {
		 
		 User userCreated= usersFacade.save( user);
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId()).toUri();
		 
		 return ResponseEntity.created(location).body(userCreated);
		 
	 }
}

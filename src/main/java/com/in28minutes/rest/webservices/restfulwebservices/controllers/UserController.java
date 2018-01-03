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
import com.in28minutes.rest.webservices.restfulwebservices.services.UserService;

@RestController
public class UserController {
	
	private static final String USERS_END_POINT = "/users";
	
	 @Autowired
	 UserService userService;
	 
	 @GetMapping(path = USERS_END_POINT)
	 public List<User> retrieveAllUsers(){
		 return userService.findAll();
	 }
	 
	 @GetMapping(path = USERS_END_POINT+"/{id}")
	 public User retrieveUser(@PathVariable int id) {
		 return userService.findOne(id);
	 }

	 @PostMapping(path = USERS_END_POINT)
	 public ResponseEntity<Object> createUser(@RequestBody User user) {
		 
		 User userCreated= userService.save( user);
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId()).toUri();
		 
		 return ResponseEntity.created(location).body(userCreated);
		 
	 }
}

package com.in28minutes.rest.webservices.restfulwebservices.controllers;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	private static final String USERS_END_POINT_JPA = "/jpa/users";
	
	private static final String USER_REL_USERS="all-users";
	
	 @Autowired
	 UsersFacade usersFacade;
	 
	 @GetMapping(path = USERS_END_POINT)
	 public List<User> retrieveAllUsers(){
		 return usersFacade.findAll();
	 }
	 
	@GetMapping(path = USERS_END_POINT + "/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		User userFound =  usersFacade.findOne(id);
		
		Resource<User> resource = new Resource<>(userFound);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel(USER_REL_USERS));
		
		return resource;

	}

	@PostMapping(path = USERS_END_POINT)
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {

		User userCreated = usersFacade.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userCreated.getId()).toUri();

		return ResponseEntity.created(location).body(userCreated);
	}
	
	@DeleteMapping(path = USERS_END_POINT + "/{id}")
	public void deleteUser(@PathVariable int id) {
		usersFacade.deleteById(id);
	}
	
	@GetMapping(path = USERS_END_POINT_JPA)
	 public List<User> retrieveAllUsersJPA(){
		 return usersFacade.jpaFindAll();
	 }
	 
	@GetMapping(path = USERS_END_POINT_JPA + "/{id}")
	public Resource<User> retrieveUserJPA(@PathVariable int id) {
		User userFound =  usersFacade.jpaFindOne(id);
		
		Resource<User> resource = new Resource<>(userFound);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel(USER_REL_USERS));
		
		return resource;

	}

	@PostMapping(path = USERS_END_POINT_JPA)
	public ResponseEntity<Object> createUserJPA(@Valid @RequestBody User user) {

		User userCreated = usersFacade.jpaSave(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userCreated.getId()).toUri();

		return ResponseEntity.created(location).body(userCreated);
	}
	
	@DeleteMapping(path = USERS_END_POINT_JPA + "/{id}")
	public void deleteUserJPA(@PathVariable int id) {
		usersFacade.jpaDeleteById(id);
	}
}

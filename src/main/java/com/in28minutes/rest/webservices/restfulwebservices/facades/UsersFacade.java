package com.in28minutes.rest.webservices.restfulwebservices.facades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.restfulwebservices.domain.User;
import com.in28minutes.rest.webservices.restfulwebservices.exceptions.UserCreatedException;
import com.in28minutes.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.services.UserJPAService;
import com.in28minutes.rest.webservices.restfulwebservices.services.UserService;

import lombok.NonNull;

@Component
public class UsersFacade {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserJPAService userJPAService;

	public User save (@NonNull User user) {
		User userSaved = userService.save(user);
		
		if(userSaved == null) {
			throw new UserCreatedException("name -"+user.getName());
		}
		return userSaved;
	}
	
	public List<User> findAll(){
		return userService.findAll();
	}
	
	public User findOne(int id){
		
		User userFound =  userService.findOne(id);
		
		if(userFound == null) {
			throw new UserNotFoundException("Id - "+id);
		}
		
		return userFound;
	}
	
	public void deleteById(int id) {
		if(!userService.deleteById(id)) {
			throw new UserNotFoundException("Id - "+id);
		}
	}
	
	public List<User> jpaFindAll(){
		return userJPAService.findAll();
	}
	
	public User jpaFindOne(int id){
		
		User userFound =  userJPAService.findById(id).orElse(null);
		
		if(userFound == null) {
			throw new UserNotFoundException("Id - "+id);
		}
		
		return userFound;
	}
	
	public void jpaDeleteById(int id) {
		userJPAService.deleteById(id);
	}
	
	public User jpaSave (@NonNull User user) {
		User userSaved = userJPAService.save(user);
		
		if(userSaved == null) {
			throw new UserCreatedException("name -"+user.getName());
		}
		return userSaved;
	}
}

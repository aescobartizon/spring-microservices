package com.in28minutes.rest.webservices.restfulwebservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.restfulwebservices.domain.User;

import lombok.NonNull;

@Component
public class UserService {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1,"Adam",new Date()));
		users.add(new User(2,"Eve",new Date()));
	}

	public List<User> findAll(){
		return users != null ? users : new ArrayList<>();
	}
	
	public User save (@NonNull User user) {
		
		if(user.getId() == null) {
			user.setId(users.size()+1);
			users.add(user);
		}else {
			
			User userStored = users.stream().filter(u -> u.getId() == user.getId()).findFirst().map(u -> new User(user.getId(),user.getName(),user.getBirthDate())).orElse(null);
			
			if(userStored == null) {
				users.add(user);
			}
		}
		
		return user;	
	}
	
	public User findOne(int id){
		return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
	}
	
	public boolean deleteById(int id){
		return users.removeIf(u -> u.getId()==id);
	}
}

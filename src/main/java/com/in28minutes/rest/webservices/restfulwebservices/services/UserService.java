package com.in28minutes.rest.webservices.restfulwebservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.rest.webservices.restfulwebservices.domain.User;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Component
@Getter
@Setter
public class UserService {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(User.builder().id(1).name("Adam").birthDate(new Date()).build());
		users.add(User.builder().id(2).name("Eve").birthDate(new Date()).build());
		users.add(User.builder().id(3).name("Jack").birthDate(new Date()).build());
		users.add(User.builder().id(4).name("Antonio").birthDate(new Date()).build());
		users.add(User.builder().id(5).name("Jorge").birthDate(new Date()).build());
		users.add(User.builder().id(6).name("JA").birthDate(new Date()).build());
		users.add(User.builder().id(7).name("Deg").birthDate(new Date()).build());
	}

	public List<User> findAll(){
		return users != null ? users : new ArrayList<>();
	}
	
	public User save (@NonNull User user) {
		
		User userStored = users.stream().filter(u -> u.getId() == user.getId()).findFirst().map(u -> User.builder().id(user.getId()).name(user.getName()).birthDate(user.getBirthDate()).build()).orElse(null);
		
		if(userStored == null) {
			users.add(user);
		}
		
		return user;	
	}
	
	public User findOne(int id){
		return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
	}
}

package com.in28minutes.rest.webservices.restfulwebservices.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.rest.webservices.restfulwebservices.domain.User;

@RunWith(SpringRunner.class)
public class UserServiceTest {
	
	private UserService userService = new UserService();
	
	private static User userTest = new User(50,"Test User",new Date());
	
	private static String updateName = "Update Name";
	
	
	@Test
	public void staticConstructorTest(){
		assertNotNull(userService.findAll());
	}
	
	@Test 
	public void addNewElement() {
		if(!Optional.ofNullable(userService.findOne(userTest.getId())).isPresent()){
			userService.save(userTest);
		}
		assertNotNull(userService.findOne(userTest.getId()));	
	}
	
	@Test 
	public void updateElement() {
		if(!Optional.ofNullable(userService.findOne(userTest.getId())).isPresent()){
			userService.save(userTest);
		}
		userTest.setName(updateName);
		userService.save(userTest);
		assertEquals(userService.findOne(userTest.getId()).getName(),updateName);	
	}
}

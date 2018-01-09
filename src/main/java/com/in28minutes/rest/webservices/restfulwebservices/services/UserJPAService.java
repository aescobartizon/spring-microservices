package com.in28minutes.rest.webservices.restfulwebservices.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.rest.webservices.restfulwebservices.domain.User;

@Repository
public interface UserJPAService extends JpaRepository<User, Integer>{

}

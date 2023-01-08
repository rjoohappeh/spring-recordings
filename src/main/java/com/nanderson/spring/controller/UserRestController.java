package com.nanderson.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nanderson.spring.model.User;
import com.nanderson.spring.service.UserService;

@RestController
public class UserRestController {
	
	private final UserService userService;
	
	@Autowired
	public UserRestController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	/*
	 * HTTP Request methods
	 * - the method by which we send a request on the internet
	 * 
	 * When we submit a login/registration form on a website, usually, a POST request is sent
	 * 
	 * When we try to retrieve a website such as google.com a GET request is sent.
	 */
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable("id") int id) {
		System.out.println(id);
		Optional<User> foundUser = userService.getById(id);
		if (foundUser.isPresent()) {
			return foundUser.get();
		}
		// once we learn about exceptions and how to handle them with Spring, we will throw an exception here
		return null;
	}
	
	// TODO: Add an endpoint that allows users of the api to create new User entities in the database.
	
}

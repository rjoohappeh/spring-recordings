package com.nanderson.spring.service;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanderson.spring.model.User;
import com.nanderson.spring.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	// TODO: Remove after next endpoint is created!
	@PostConstruct
	public void postContruct() {
		userRepository.save(new User("testUsername", "testPassword"));
	}

	// SELECT username, password FROM Users WHERE id = 1
	public Optional<User> getById(int id) {
		return userRepository.findById(id);
	}
}

package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;

import com.revature.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	
	public UserService() {
	}

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User findById(int id) {
		return userRepository.findById(id);
	}

}

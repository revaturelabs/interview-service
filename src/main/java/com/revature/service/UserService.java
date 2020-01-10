package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;

import com.revature.repository.UserRepository;

@Service
public class UserService {

	private UserRepository ur;
	
	public UserService() {
	}

	@Autowired
	public UserService(UserRepository ur) {
		super();
		this.ur = ur;
	}

	public List<User> getAllUsers() {
		return ur.findAll();
	}

	public User findById(int id) {
		return ur.findById(id);
	}

}

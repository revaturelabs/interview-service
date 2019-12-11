package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;

import com.revature.repository.UserRepository;

@Service
public class UserService {

	public UserService() {
		super();
	}

	public List<User> getAllUsers() {
		return ur.findAll();
	}

	public User findById(int id) {
		return ur.findById(id);
	}

	private UserRepository ur;

	public UserRepository getRepository() {
		return ur;
	}

	@Autowired
	public void setRepository(UserRepository ur) {
		this.ur = ur;
	}

}

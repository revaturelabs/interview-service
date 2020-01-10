package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.commons.codec.digest.DigestUtils;

import com.revature.model.User;
import com.revature.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/users")
public class UserController {

	private UserRepository repository;

	public UserController() {
	}
	
	@Autowired
	public UserController(UserRepository repository) {
		super();
		this.repository = repository;
	}


	/**
	 * <p>
	 * Very basic method to register a user to database
	 * </p>
	 * 
	 * @author Daniel Cavaretta * @param user the user information from logging in
	 * @return the user information after username and password is verified
	 */
	@GetMapping(value = "/register")
	public User register(@RequestBody User user) {
		String password = user.getPassword(); // get password
		user.setPassword(DigestUtils.sha256Hex(password)); // hash password
		repository.save(user); // persist the change to the DB
		return user;
	}

	/**
	 * <p>
	 * Login Method
	 * </p>
	 * 
	 * @author Daniel Cavaretta and Brittany Tinnin
	 * @param user the user information from logging in
	 * @return the user information after username and password is verified
	 */
	@PostMapping(value = "/login")
	public User login(@RequestBody User user) {
		for (User u : repository.findAll()) {
			if (user.getUsername().equals(u.getUsername())) {
				if (u.getPassword().equals(DigestUtils.sha256Hex(user.getPassword()))) {
					return u;
				}
			}
		}
		return null;
	}

	/**
	 * <p>
	 * Find all users Method
	 * </p>
	 * 
	 * @author Brittany Tinnin
	 * @return a list of all users
	 */
	@GetMapping(value = "/allusers")
	public List<User> findAll() {
		return repository.findAll();
	}

	@PostMapping(value = "/authorize")
	public boolean authorizeUser(@RequestHeader(name = "auth") String token) {
		User u = repository.findByUsername(token);
		if (u == null) {
			throw new UnauthorizedException();
		} else {
			return true;
		}
	}
}

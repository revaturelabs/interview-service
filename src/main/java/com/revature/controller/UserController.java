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
	@Autowired
	private UserRepository repository;

	/**
	 * <p>
	 * Very basic method to save a user to database
	 * </p>
	 * 
	 * @author Daniel Cavaretta, William Liederer and Brittany Tinnin
	 */
	@GetMapping(value = "/users")
	public String save() {
		User dev = new User(2, "admin", DigestUtils.sha256Hex("admin"));
		repository.save(dev);
		return "worked";
	}

	/**
	 * <p>
	 * Very basic method to register a user to database
	 * </p>
	 * 
	 * @author Daniel Cavaretta
	 * 	 * @param user the user information from logging in
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
		System.out.println(user);
		for (User u : repository.findAll()) {
			if (user.getUsername().equals(u.getUsername())) {
				if (user.getPassword().equalsIgnoreCase(DigestUtils.sha256Hex(u.getPassword()))) {
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

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
/** The main controller for obtaining information about an interviewer.
 * @author Daniel Cavaretta
 * @author Brittany Tinnin */
public class UserController {

	/** A user repository for accessing and modifying database information relating to interviewers. */
	private UserRepository userRepository;

	/** Creates a new user controller, with all properties set to their default values. */
	public UserController() {
	}
	
	@Autowired
	/** Creates a new user controller, setting its user repository to an existing repository.
	 * @param userRepository A user repository for accessing and modifying database information 
	 relating to interviewers. */
	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@GetMapping(value = "/register")
	/** Registers a new interviewer to the database, in response to an HTTP Get request at the uri
	 "/users/register/". The interviewer's password is stored in a hashed form.
	 * @param user The interviewer being registered. Their information is submitted in the body
	 of the HTTP request.
	 * @return The interviewer being registered, after their information has been stored. */
	public User register(@RequestBody User user) {
		String password = user.getPassword(); // get password
		user.setPassword(DigestUtils.sha256Hex(password)); // hash password
		userRepository.save(user); // persist the change to the DB
		return user;
	}

	/** Logs an interviewer into the database, in response to an HTTP Post request
	 at the uri "/users/login".
	 * @param The interviewer who is logging in.
	 * @return The interviewer who has logged in, if the login was successful,
	 or null if the login failed. */
	@PostMapping(value = "/login")
	public User login(@RequestBody User user) {
		for (User u : userRepository.findAll()) {
			if (user.getUsername().equals(u.getUsername())) {
				if (u.getPassword().equals(DigestUtils.sha256Hex(user.getPassword()))) {
					return u;
				}
			}
		}
		return null;
	}

	@GetMapping(value = "/allusers")
	/** Returns a list of all interviewers in the database, in response to
	 an HTTP Get method at the uri "/users/allusers".
	 * @return A list of all interviewers in the database. */
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@PostMapping(value = "/authorize")
	/** Checks if an interviewer is authorized, in response to an HTTP Post request
	 at the uri "/users/authorize". 
	 * @param token The username of the interviewer, which is submitted in the body
	 of the HTTP request.
	 * @return True if the interviewer is authorized, and false if they are not. */
	public boolean authorizeUser(@RequestHeader(name = "auth") String token) {
		User user = userRepository.findByUsername(token);
		if (user == null) {
			throw new UnauthorizedException();
		} else {
			return true;
		}
	}
}

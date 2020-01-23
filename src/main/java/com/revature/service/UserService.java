package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.User;

import com.revature.repository.UserRepository;

/** The service layer (or business logic) for the User class. */
@Service
public class UserService {

	/** A CRUD repository that links this user service to the database. */
	private UserRepository userRepository;
	
	/** Creates a new user service, with all properties set to their default values. */
	public UserService() {
	}

	@Autowired
	/** Creates a new user service, setting its user repository to an existing repository.
	 * @param userRepository A CRUD repository that links this user service to the database. */
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	/** Returns a list of all interviewers in the database.
	 * @return A list of all interviewers in the database. */
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	/** Retrieves the interviewer from the database whose ID matches the provided number.
	 Returns null if no such interviewer is found.
	 * @param id The integer that uniquely identifies the interviewer.
	 * @return The interviewer from the database whose ID matches the provided number,
	 or null if no such interviewer is found. */
	public User findById(int id) {
		return userRepository.findById(id);
	}

}

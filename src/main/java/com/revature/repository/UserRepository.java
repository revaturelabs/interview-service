package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.revature.model.User;

/** The custom User Repository interface extends the Crud Repository interface for generic CRUD operation
 * @author Brittany Tinnin and Will Liederer */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	/** Retrieves the interviewer from the database whose username matches the provided string.
	 Returns null if no such interviewer is found.
	 * @param username The interviewer's username.
	 * @return The interviewer from the database whose username matches the provided string,
	 or null if no such interviewer is found. */
	User findByUsername(String username);

	/** Retrieves the interviewer from the database whose ID matches the provided number.
	 Returns null if no such interviewer is found.
	 * @param id The integer that uniquely identifies the interviewer.
	 * @return The interviewer from the database whose ID matches the provided number,
	 or null if no such interviewer is found. */
	User findById(int id);
}

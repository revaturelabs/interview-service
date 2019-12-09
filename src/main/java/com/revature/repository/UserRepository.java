package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.revature.model.User;

/**
 * 
 * @author Brittany Tinnin and Will Liederer
 * 
 *         <p>
 *         The custom User Repository interface extends the Crud Repository
 *         Interface for generic CRUD operation
 *         </p>
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);

	User findById(int id);
}

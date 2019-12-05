package com.revature.service;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.UserBean;


/**
 * 
 * @author Brittany Tinnin and Will Liederer
 * 
 * <p>The custom User Repository interface extends the Crud Repository Interface for generic CRUD operation</p>
 */

@Repository
public interface UserRepository extends CrudRepository<UserBean, Integer> {
	UserBean findByUsername(String username);
}

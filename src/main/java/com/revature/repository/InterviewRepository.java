package com.revature.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.model.Interview;

/**
 * A simple Interview Repo Interface.
 * 
 * @author Davin Merry
 * @author Adriana Long
 */
public interface InterviewRepository extends CrudRepository<Interview, Integer> {
	
}

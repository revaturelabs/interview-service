package com.revature.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.model.Interview;

/**
 * A simple Interview Repo Interface.
 * 
 * @author Davin Merry
 * @author Adriana Long
 */
public interface InterviewRepository extends CrudRepository<Interview, Integer> {
	List<Interview> findById(int id);
}

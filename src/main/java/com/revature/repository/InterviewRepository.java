package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Interview;

/**
 * A simple Interview Repo Interface.
 * 
 * @author Davin Merry
 * @author Adriana Long
 */
@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer>, CustomRepo {
	Interview findById(int id);
}

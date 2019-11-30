package com.revature.repository;

import java.util.List;

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
public interface InterviewRepository extends JpaRepository<Interview, Integer> {
	List<Interview> findById(int id);
}

package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import com.revature.model.Job;

/**
 * Repository for adding and retrieving jobs
 * 
 * @author John Thaddeus Kelly
 */
@Repository
@Transactional
public interface JobRepository extends JpaRepository<Job, Integer>, CustomRepo {
	Job findById(int id);

	Job findByTitle(String title);
}

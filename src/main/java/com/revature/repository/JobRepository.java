package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
	
	List<Job> findByTitle(String title, Pageable page);
}

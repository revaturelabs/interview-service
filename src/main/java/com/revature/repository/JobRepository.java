package com.revature.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Job;
/**
 * Repository for adding and retrieving jobs
 * @author John Thaddeus Kelly
 */
@Repository
public interface JobRepository extends CrudRepository<Job, Integer>{
	List<Job> findByTitle(String title);
}

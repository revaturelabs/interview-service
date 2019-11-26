package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Interview;
import com.revature.model.Job;
/**
 * Repository for adding and retrieving jobs
 * @author John Thaddeus Kelly
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Integer>{
	List<Job> findByTitle(String title);
	Job findById(int id);

}

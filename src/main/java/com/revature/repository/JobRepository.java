package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Job;

/**
 * Repository for adding and retrieving jobs
 * 
 * @author John Thaddeus Kelly
 */
@Repository
<<<<<<< HEAD
public interface JobRepository extends JpaRepository<Job, Integer> {
=======
public interface JobRepository extends JpaRepository<Job, Integer>, CustomJobRepo{
>>>>>>> 386fc9c5056f94b4759233cd205789cfca0a3bf6
	Job findById(int id);

	Job findByTitle(String title);
}

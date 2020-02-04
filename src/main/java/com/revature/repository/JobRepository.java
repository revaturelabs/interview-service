package com.revature.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Interview;
import com.revature.model.Job;
import com.revature.model.Skill;

/**
 * Repository for adding and retrieving jobs
 * @author 
 */
@Repository
@Transactional
public interface JobRepository extends JpaRepository<Job, Integer> {
	
	/** Retrieves a job from the database that matches the provided ID.
	 * @param id The integer that uniquely identifies the job.
	 * @return The job whose ID matches the one provided, or null if no matching job is found. */
	Job findById(int id);

	/** Returns a list of jobs whose name starts with the provided string, ignoring upper and lower case.
	 * @param title A string which will be matched with all jobs whose names start with that string,
	 ignoring upper and lower case. 
	 * @return A list of jobs whose name starts with the provided string, ignoring upper and lower case. */
	List<Job> findByTitleStartsWithIgnoreCase(String title);
	
	/** Returns a list of jobs on a given page whose name starts with the provided string,
	 ignoring upper and lower case.
	 * @param title A string which will be matched with all jobs whose names start with that string,
	 ignoring upper and lower case. 
	 * @param page The page that will be searched for matching jobs. Any jobs outside this page will
	 not be returned in the results list, even if they start with the provided string.
	 * @return A list of jobs on a given page whose name starts with the provided string,
	 ignoring upper and lower case. */
	List<Job> findByTitleStartsWithIgnoreCase(String title, Pageable page);
	
	List<Job> findBySkills(List<Skill> skills);

	
}

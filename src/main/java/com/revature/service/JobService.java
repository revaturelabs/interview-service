package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.revature.model.Job;
import com.revature.model.Skill;
import com.revature.repository.JobRepository;

/**
 * The service layer (or business logic) for the Job object.
 * 
 * @author Adriana Long
 */
@Service
public class JobService {

	/** A CRUD repository that links this job service to the database. */
	private JobRepository jobRepository;

	/** The number of jobs to return on each page. Default is 10. */
	private int pageReturnSize = 10;

	/**
	 * Creates a new job service, with all properties set to their default values.
	 */
	public JobService() {
	}

	@Autowired
	/**
	 * Creates a new job service and sets its job repository to an existing
	 * repository.
	 * 
	 * @param jobRepository A CRUD repository that links this job service to the
	 *                      database.
	 */
	public JobService(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	/**
	 * Saves a job to the database.
	 * 
	 * @param job The job being saved.
	 * @return True if the job was saved successfully, and false if the job was not
	 *         saved.
	 */
	public Job insertJobInfo(Job job) {
		try {
			return jobRepository.save(job);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Returns an iterable data structure containing all jobs in the database.
	 * 
	 * @return An iterable data structure containing all jobs in the database.
	 */
	public Iterable<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	/**
	 * Returns a list of all jobs on a given page.
	 * 
	 * @param page An integer identifying the page to search for jobs.
	 * @return A list of all jobs on the specified page.
	 */
	public List<Job> getAllJobsPaged(int page) {
		return jobRepository.findAll(PageRequest.of(page, this.pageReturnSize)).getContent();
	}

	/**
	 * Retrieves the job whose ID matches the provided number. Returns null if no
	 * such job is found.
	 * 
	 * @param id The integer that uniquely identifies the job.
	 * @return The job whose ID matches the provided number, or null if no such job
	 *         is found.
	 */
	public Job findById(int id) {
		return jobRepository.findById(id);
	}

	/**
	 * Returns a list of jobs whose names start with the provided string, ignoring
	 * upper and lower case.
	 * 
	 * @param title A string that will filter out all jobs whose names do not start
	 *              with the string, ignoring upper and lower case.
	 * @return A list of jobs whose names start with the provided string, ignoring
	 *         upper and lower case.
	 */
	public List<Job> findByTitle(String title) {
		return jobRepository.findByTitleStartsWithIgnoreCase(title);
	}

	/**
	 * Returns an iterable data structure containing all jobs in the database.
	 * 
	 * @return An iterable data structure containing all jobs in the database.
	 */
	public Iterable<Job> findAll() {
		return jobRepository.findAll();
	}

	/**
	 * Returns a list of jobs on a given page whose names start with the provided
	 * string, ignoring upper and lower case.
	 * 
	 * @param title A string that will filter out all jobs whose names do not start
	 *              with the string, ignoring upper and lower case.
	 * @param page  An integer identifying the page to search for jobs. All jobs
	 *              outside this page will not be included in the returned list,
	 *              even if their names start with the title parameter.
	 * @return A list of jobs on a given page whose names start with the provided
	 *         string, ignoring upper and lower case.
	 */
	public List<Job> findByTitlePaged(String title, int page) {
		return jobRepository.findByTitleStartsWithIgnoreCase(title, PageRequest.of(page, this.pageReturnSize));
	}

	/** Returns a filtered list of all jobs on a given page. 
     * @param given job search value to filter with.
     * @param page An integer identifier the page to search for profiles.
     * @return A list of filtered jobs on a given page. */
	public List<Job> getFilterJobsPaged(String searchValue, int page) {
		return jobRepository.findByTitleStartsWithIgnoreCaseOrLocationStartsWithIgnoreCase(searchValue,searchValue, PageRequest.of(page, this.pageReturnSize));

	}
	
	public List<Job> findBySkills(int[] skillIds, int page){
		return jobRepository.findBySkills(skillIds, PageRequest.of(page, this.pageReturnSize));
	}
}

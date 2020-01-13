package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.revature.model.Job;
import com.revature.repository.JobRepository;

/**
 * The service layer (or business logic) for the Job object.
 * 
 * @author Adriana Long
 */
@Service
public class JobService {
	
	private JobRepository jobRepository;

	public JobService() {
	}
	
	@Autowired
	public JobService(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Transactional
	public boolean insertJobInfo(Job job) {
		try {
			jobRepository.mergeEntity(job);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean updateJobInfo(Job job) {
		try {
			Job job2;
			int id = job.getId();
			job2 = jobRepository.findById(id);
			job2.setFilled(true);
			jobRepository.save(job2);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public Iterable<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	public Job findById(int id) {
		return jobRepository.findById(id);
	}

	public Job findByTitle(String title) {
		return jobRepository.findByTitle(title);
	}

	public Iterable<Job> findAll() {
		return jobRepository.findAll();
	}
}

package com.revature.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
	
	private int pageReturnSize = 10;
	
	public JobService() {
	}
	
	@Autowired
	public JobService(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}


	public Job insertJobInfo(Job job) {
		try {
			return jobRepository.save(job);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}


	public Iterable<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	public List<Job> getAllJobsPaged(int page){
		return jobRepository.findAll(PageRequest.of(page, this.pageReturnSize)).getContent();
	}

	public Job findById(int id) {
		return jobRepository.findById(id);
	}

	public List<Job> findByTitle(String title) {
		return jobRepository.findByTitleStartsWithIgnoreCase(title);
	}

	public Iterable<Job> findAll() {
		return jobRepository.findAll();
	}
	
		
	public List<Job> findByTitlePaged(String title,int page){
		return jobRepository.findByTitleStartsWithIgnoreCase(title, PageRequest.of(page, this.pageReturnSize));
	}
	
}

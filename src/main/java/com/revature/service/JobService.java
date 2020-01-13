package com.revature.service;

import java.util.List;

import javax.transaction.Transactional;

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
	
	private JobRepository jr;

	private int pageReturnSize = 10;
	
	public JobService() {
	}
	
	@Autowired
	public JobService(JobRepository jr) {
		this.jr = jr;
	}

	@Transactional
	public boolean insertJobInfo(Job j) {
		try {
			jr.mergeEntity(j);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean updateJobInfo(Job p) {
		try {
			Job b;
			int id = p.getId();
			b = jr.findById(id);
			b.setFilled(true);
			jr.save(b);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public Iterable<Job> getAllJobs() {
		return jr.findAll();
	}

	public Job findById(int id) {
		return jr.findById(id);
	}

	public Job findByTitle(String title) {
		return jr.findByTitle(title);
	}

	public List<Job> findByTitlePaged(String title,int page){
		return jr.findByTitle(title, PageRequest.of(page, this.pageReturnSize));
	}

	public Iterable<Job> findAll() {
		return jr.findAll();
	}
	
	public List<Job> getAllJobsPaged(int page){
		return jr.findAll(PageRequest.of(page, this.pageReturnSize)).getContent();
	}
		
}

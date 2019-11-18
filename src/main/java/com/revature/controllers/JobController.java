package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Job;
import com.revature.repository.JobRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/jobs")
public class JobController{
	@Autowired
	private JobRepository jc;
	
	/**
	 * Add jobs to the database
	 * 
	 * @return String confirming successful or unsuccessful entry
	 * @author John Thaddeus Kelly
	 */
	@PostMapping("/saveJob")
	public boolean save(@RequestBody Job job) {
		try {
			jc.save(job);
			return true;
		}catch (Exception e){
			return false;
		}
	}
	
	/**
	 * Retrieve jobs from the database
	 * 
	 * @return A list of jobs
	 * @author John Thaddeus Kelly
	 */
	@GetMapping("/jobAll")
	public Iterable<Job> getAll(){
		return jc.findAll();
	}
	
	@GetMapping("/jobTitle/{title}")
	public List<Job> getByTitle(@PathVariable String title){
		return jc.findByTitle(title);
	}
}

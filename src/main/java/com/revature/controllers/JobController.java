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
	
	public JobRepository getRepo() {
		return jc;
	}
	@Autowired
	public void setRepo(JobRepository jc) {
		this.jc = jc;
	}
	/*
	 * @author John Thaddeus Kelly
	 * 		Add jobs to the database
	 * @returns String confirming successful or unsuccessful entry
	 */
	@PostMapping("/saveJob")
	public String save(@RequestBody Job job) {
		try {
			jc.save(job);
			return "Saved";
		}catch (Exception e){
			return "Not Saved";
		}
	}
	
	/*
	 * @author John Thaddeus Kelly
	 * 		Retrieve jobs from the database
	 * @returns the job
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

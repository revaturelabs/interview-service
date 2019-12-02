package com.revature.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Job;
import com.revature.service.JobService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/jobs")
public class JobController{
    @Autowired
    private JobService js;
    
	@Autowired
	private AuthInterface ai;
    
    /**
     * Add jobs to the database
     * 
     * @return String confirming successful or unsuccessful entry
     * @author John Thaddeus Kelly
     * @author Adriana Long
     */
    @PostMapping("/saveJob")
    public boolean insertJobInfo(@RequestHeader(name="auth") String token, @RequestBody Job job) {
    	if (ai.authorize(token)) {
    		return js.insertJobInfo(job);
    	} else {
    		return false;
    	}
	}
    
    /**
     * Update jobs to the database
     * 
     * @return String confirming successful or unsuccessful entry
     * @author william liederer
     */
    @PatchMapping("/updateJob")
	public boolean updateJobInfo(@RequestHeader(name="auth") String token, @RequestBody Job b) {
    	if (ai.authorize(token)) {
    		return js.updateJobInfo(b);
    	} else {
    		return false;
    	}
    }
    
    /**
     * Retrieve jobs from the database
     * 
     * @return A list of jobs
     * @author John Thaddeus Kelly
     * @author Adriana Long
     */
    @GetMapping("/allJobs")
    public Iterable<Job> getAll(@RequestHeader(name="auth") String token) {
    	if (ai.authorize(token)) {
    		return js.findAll();
    	} else {
    		return null;
    	}
    }
    
    /**
     * @author Adriana Long
     * @param title
     * @return job by title
     */
    @GetMapping("/jobTitle/{title}")
    public Job getByTitle(@RequestHeader(name="auth") String token, @PathVariable String title) {
    	if (ai.authorize(token)) {
    		return js.findByTitle(title);
    	} else {
    		return null;
    	}
    }
}
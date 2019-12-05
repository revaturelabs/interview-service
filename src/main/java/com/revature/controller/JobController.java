<<<<<<< HEAD:src/main/java/com/revature/controllers/JobController.java
package com.revature.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    /**
     * Add jobs to the database
     * 
     * @return String confirming successful or unsuccessful entry
     * @author John Thaddeus Kelly
     * @author Adriana Long
     */
    @PostMapping("/saveJob")
    public boolean insertJobInfo(@RequestBody Job job) {
    		return js.insertJobInfo(job);
	}
    
    /**
     * Update jobs to the database
     * 
     * @return String confirming successful or unsuccessful entry
     * @author william liederer
     */
    @PatchMapping("/updateJob")
	public boolean updateJobInfo(@RequestBody Job b) {
    		return js.updateJobInfo(b);
    }
    
    /**
     * Retrieve jobs from the database
     * 
     * @return A list of jobs
     * @author John Thaddeus Kelly
     * @author Adriana Long
     */
    @GetMapping("/allJobs")
    public Iterable<Job> getAll() {
    		return js.findAll();
    }
    
    /**
     * @author Adriana Long
     * @param title
     * @return job by title
     */
    @GetMapping("/jobTitle/{title}")
    public Job getByTitle(@PathVariable String title) {
    		return js.findByTitle(title);
    }
=======
package com.revature.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    /**
     * Add jobs to the database
     * 
     * @return String confirming successful or unsuccessful entry
     * @author John Thaddeus Kelly
     * @author Adriana Long
     */
    @PostMapping("/saveJob")
    public boolean insertJobInfo(@RequestBody Job job) {
    		return js.insertJobInfo(job);
	}
    
    /**
     * Update jobs to the database
     * 
     * @return String confirming successful or unsuccessful entry
     * @author william liederer
     */
    @PatchMapping("/updateJob")
	public boolean updateJobInfo(@RequestBody Job b) {
    		return js.updateJobInfo(b);
    }
    
    /**
     * Retrieve jobs from the database
     * 
     * @return A list of jobs
     * @author John Thaddeus Kelly
     * @author Adriana Long
     */
    @GetMapping("/allJobs")
    public Iterable<Job> getAll() {
    		return js.findAll();
    }
    
    /**
     * @author Adriana Long
     * @param title
     * @return job by title
     */
    @GetMapping("/jobTitle/{title}")
    public Job getByTitle(@PathVariable String title) {
    		return js.findByTitle(title);
    }
>>>>>>> userserviceintegration:src/main/java/com/revature/controller/JobController.java
}
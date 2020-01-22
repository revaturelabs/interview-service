package com.revature.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

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
import com.revature.model.Skill;
import com.revature.service.JobService;
import com.revature.service.SkillService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/jobs")
public class JobController {

	private JobService jobService;

	private SkillService skillService;

    /**
     * Add jobs to the database
     * 
     * @return String confirming successful or unsuccessful entry
     * @author John Thaddeus Kelly
     * @author Adriana Long
     */
    
    public JobController() {
	}

    @Autowired
    public JobController(JobService jobService, SkillService skillService) {
		super();
		this.jobService = jobService;
		this.skillService = skillService;
	}

    /**
     * This will create a new job if sent a invalid id or update a 
     * valid id
     * 
     * @param job
     * @return a boolean if it ran/Hopfully worked
     */

	@PostMapping("/saveJob")
    @Transactional
    public Job insertJobInfo(@RequestBody Job job) {
	
        return jobService.insertJobInfo(job);
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
        return jobService.findAll();
    }

    @GetMapping("/allJobs/{page}")
    public List<Job> getAllPaged(@PathVariable int page){
    	return jobService.getAllJobsPaged(page);
    }

    /**
     * @author Adriana Long
     * @param title
     * @return job by title
     */
    @GetMapping("/jobTitle/{title}")
    public List<Job> getByTitle(@PathVariable String title) {
        return jobService.findByTitle(title);
    }
    
	
	    @GetMapping("/jobTitle/{title}/{page}")
    public List<Job> getByTitle(@PathVariable String title, @PathVariable int page) {
        return jobService.findByTitlePaged(title, page);
    }
    
    
}

package com.revature.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Job;
import com.revature.service.JobService;
import com.revature.service.SkillService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/jobs")
/** The main controller for obtaining information about an Interview from the
database.
* @author John Thaddeus Kelly
* @author Adriana Long */
public class JobController {

	/** A job service object that performs the business logic for the job class. */
	private JobService jobService;

	/** A skill service object that performs the business logic for the skills required for this job. */
	private SkillService skillService;

	/** Creates a new job controller, with all properties set to their default values. */
    public JobController() {
	}

    @Autowired
    /** Creates a new job controller, with all properties set to the provided values.
     * @param jobService A job service object that performs the business logic for the job class.
     * @param skillService A skill service object that performs the business logic 
     for the skills required for this job. */
    public JobController(JobService jobService, SkillService skillService) {
		super();
		this.jobService = jobService;
		this.skillService = skillService;
	}

	@PostMapping
	@Transactional
	/** Saves a job to the database, in response to an HTTP Post request at the uri
	 "/jobs/saveJob". If a job with the same ID as the provided job already exists,
	 this job will updated. If no such job exists, a new one will be added to the database.
	 * @param job The job being saved.
	 * @return True if the job was saved successfully, and false if the job was not saved. 
   */ public Job insertJobInfo(@RequestBody Job job) {
        return jobService.insertJobInfo(job);
    }

    @GetMapping
    /** Returns an iterable data structure containing all jobs in the database,
	 in response to an HTTP Get request at the uri "/jobs/allJobs".
	 * @return An iterable data structure containing all jobs in the database.
    */public Iterable<Job> getAll() {
        return jobService.findAll();
    }

    @GetMapping("/{page}")
	/** Returns a list of all jobs on a given page, in response to an HTTP Get request
	 at the uri "/jobs/{page}" where {page} refers to an integer identifying 
	 the page to search for jobs.
	 * @param page An integer identifying the page to search for jobs.
	 * @return A list of all jobs on the specified page. */
    public List<Job> getAllPaged(@PathVariable int page,
			@RequestParam("filtervalue") String value, @RequestParam("skillids") String data) {

    	if (!(value.isEmpty() && data.isEmpty())) {
 			List<Job> jobs = new ArrayList<>();
 			List<Job> jobsList2 = new ArrayList<>();
 			//grabs jobs with filter by job title, location
 			List<Job> jobsList1 = jobService.getFilterJobsPaged(value, page);
 			
 			//parse skill id string into int[] array, and grab jobs filtered by skills
 			if (!data.isEmpty()) {
	 			int[] skillIds = Arrays.asList(data.split(",")).stream().mapToInt(Integer::parseInt).toArray();
	 			jobsList2 = jobService.findBySkills(skillIds, page);
 			}
 			
 			if (!jobsList1.isEmpty() && !value.isEmpty()) {
 				jobs.addAll(jobsList1);
 				jobs.addAll(jobsList2);
 				jobsList2.retainAll(jobs);
 			}else {
 				jobs.addAll(jobsList2);
 			}
 			return jobs;
 		}else {
 			return jobService.getAllJobsPaged(page);
 		}
	}

    @GetMapping("/title/{title}")
	/** Returns a list of jobs whose names start with the provided string,
	 in response to an HTTP Get request at the uri
	 "/jobs/title/{title}" where {title} refers to a string that will filter out all jobs 
	 whose names do not start with the string, ignoring upper and lower case.
	 * @param title A string that will filter out all jobs whose names do not start with the string,
	 ignoring upper and lower case.
	 * @return A list of jobs whose names start with the provided string,
	 ignoring upper and lower case. */
    public List<Job> getByTitle(@PathVariable String title) {
        return jobService.findByTitle(title);
    }
    
	
	@GetMapping("/title/{title}/{page}")
	/** Returns a list of jobs on a given page whose names start with the provided string,
	 in response to an HTTP Get request at the uri "/jobs/title/{title}/{page}"
	 where {title} refers to a string that will filter out all jobs 
	 whose names do not start with the string, ignoring upper and lower case,
	 and {page} refers to an integer identifying the page to search for jobs.
	 * @param title A string that will filter out all jobs whose names do not start with the string,
	 ignoring upper and lower case.
	 * @param page An integer identifying the page to search for jobs. All jobs outside this page
	 will not be included in the returned list, even if their names start with the title parameter.
	 * @return A list of jobs on a given page whose names start with the provided string,
	 ignoring upper and lower case. */
    public List<Job> getByTitle(@PathVariable String title, @PathVariable int page) {
        return jobService.findByTitlePaged(title, page);
    }
    

    
}

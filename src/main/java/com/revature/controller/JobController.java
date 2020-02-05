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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
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
    /** Creates a new job controller, with all propertiers set to the provided values.
     * @param jobService A job service object that performs the business logic for the job class.
     * @param skillService A skill service object that performs the business logic 
     for the skills required for this job. */
    public JobController(JobService jobService, SkillService skillService) {
		super();
		this.jobService = jobService;
		this.skillService = skillService;
	}

	@PostMapping("/saveJob")
  @Transactional
	/** Saves a job to the database, in response to an HTTP Post request at the uri
	 "/jobs/saveJob". If a job with the same ID as the provided job already exists,
	 this job will updated. If no such job exists, a new one will be added to the database.
	 * @param job The job being saved.
	 * @return True if the job was saved successfully, and false if the job was not saved. 
   */ public Job insertJobInfo(@RequestBody Job job) {
        return jobService.insertJobInfo(job);
    }


    @GetMapping("/allJobs")
    /** Returns an iterable data structure containing all jobs in the database,
	 in response to an HTTP Get request at the uri "/jobs/allJobs".
	 * @return An iterable data structure containing all jobs in the database.
    */public Iterable<Job> getAll() {
        return jobService.findAll();
    }

    @GetMapping("/allJobs/{page}")
	/** Returns a list of all jobs on a given page, in response to an HTTP Get request
	 at the uri "/jobs/allJobs/{page}" where {page} refers to an integer identifying 
	 the page to search for jobs.
	 * @param page An integer identifying the page to search for jobs.
	 * @return A list of all jobs on the specified page. */
    public List<Job> getAllPaged(@PathVariable int page, @RequestHeader("usefilter") boolean useFilter,
			@RequestHeader("value") String value, @RequestHeader("skillids") String data) {
 		if (useFilter) {
 			List<Job> jobs = new ArrayList<>();
 			
 			//grabs jobs with filter by job title, location
 			List<Job> temp1 = jobService.getFilterJobsPaged(value, page);
 			
 			//parse skill id string into int[] array, and grab jobs filtered by skills
 			int[] skillIds = Arrays.asList(data.split(",")).stream().mapToInt(Integer::parseInt).toArray();
 			List<Job> temp2 = jobService.findBySkills(skillIds, page);

 			jobs.addAll(temp1);
 			jobs.addAll(temp2);
 			return jobs;
 		}else {
 			return jobService.getAllJobsPaged(page);
 		}
	}
    
    @GetMapping("/test")
    public List<Job> testDB() {
    	int[] skillIds = {1, 2};
    	return jobService.findBySkills(skillIds, 0);
    }

    @GetMapping("/jobTitle/{title}")
	/** Returns a list of jobs whose names start with the provided string,
	 in response to an HTTP Get request at the uri
	 "/jobs/jobTitle/{title}" where {title} refers to a string that will filter out all jobs 
	 whose names do not start with the string, ignoring upper and lower case.
	 * @param title A string that will filter out all jobs whose names do not start with the string,
	 ignoring upper and lower case.
	 * @return A list of jobs whose names start with the provided string,
	 ignoring upper and lower case. */
    public List<Job> getByTitle(@PathVariable String title) {
        return jobService.findByTitle(title);
    }
    
	
	@GetMapping("/jobTitle/{title}/{page}")
	/** Returns a list of jobs on a given page whose names start with the provided string,
	 in response to an HTTP Get request at the uri "/jobs/jobTitle/{title}/{page}"
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

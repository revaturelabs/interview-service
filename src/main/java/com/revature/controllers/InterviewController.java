package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Interview;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.service.InterviewService;
import com.revature.service.JobService;
import com.revature.service.ProfileService;

/**
 * The main controller for obtaining information about an Interview
 * from the database.
 * 
 * @author Davin Merry
 * @author Adriana Long
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/interviews")
public class InterviewController {
	@Autowired
	private InterviewService is;
	 @Autowired
	    private JobService js;
	 @Autowired
	    private ProfileService ps;
	
	@PostMapping("/saveInterview")
	public boolean saveInterview(@RequestBody Interview interview) {
		int id1 = interview.getProfile().getId();
		int id2 = interview.getJob().getId();
		
		Profile profile = ps.findById(id1);
		Job job = js.findById(id2);
		interview.setJob(job);
		interview.setProfile(profile);
		return is.insertInterviewInfo(interview);
	}
	
	@GetMapping("/allInterviews")
	public Iterable<Interview> getAll() {
		return is.getAllInterviews();
	}
	
	
}

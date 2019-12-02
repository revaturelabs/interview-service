package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Comment;
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
	
	@Autowired
	private AuthInterface ai;
	
	@PostMapping("/saveInterview")
	public boolean saveInterview(@RequestHeader(name="auth") String token, @RequestBody Interview interview) {
		if (ai.authorize(token)) {
			int id1 = interview.getProfile().getId();
			int id2 = interview.getJob().getId();
			Profile profile = ps.findById(id1);
			Job job = js.findById(id2);
	
			interview.setJob(job);
			interview.setProfile(profile);
			return is.insertInterviewInfo(interview);
		} else {
			return false;
		}
	}
	
	@PostMapping("/insertComment")
	public boolean insertComment(@RequestHeader(name="auth") String token, @RequestParam int id, @RequestBody Comment comment) {
		if (ai.authorize(token)) {
			return is.insertCommentInInterview(id, comment);
		} else {
			return false;
		}
	}
	
	@GetMapping("/allInterviews")
	public Iterable<Interview> getAll(@RequestHeader(name="auth") String token) {
		if (ai.authorize(token)) {
			return is.getAllInterviews();
		} else {
			return null;
		}
	}
	
	@GetMapping("/id/{id}")
    public Interview getById(@RequestHeader(name="auth") String token, @PathVariable int id) {
		if (ai.authorize(token)) {
			return is.getById(id);
		} else {
			return null;
		}
    }
}

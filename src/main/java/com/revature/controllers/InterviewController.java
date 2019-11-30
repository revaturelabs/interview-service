package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Interview;

import com.revature.service.InterviewService;

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
	
	@PostMapping("/saveInterview")
	public boolean saveInterview(@RequestBody Interview interview) {
		return is.insertInterviewInfo(interview);
	}
	
	@GetMapping("/allInterviews")
	public Iterable<Interview> getAll() {
		return is.getAllInterviews();
	}
	
	
}

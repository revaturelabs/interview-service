package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Interview;
import com.revature.model.InterviewInterviewer;
import com.revature.service.InterviewInterviewerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/interviewInterviewer")
public class InterviewInterviewerController {
	
	private InterviewInterviewerService interviewInterviewerService;

	public InterviewInterviewerController() {
		super();
	}

	@Autowired
	public InterviewInterviewerController(InterviewInterviewerService interviewInterviewerService) {
		super();
		this.interviewInterviewerService = interviewInterviewerService;
	}
	
	@GetMapping("/interviewInterviewer")
	public InterviewInterviewer findById(int id) {
		return interviewInterviewerService.findById(id);
	}
	
	@GetMapping("/allInterviewInterviewerByInterview")
	public List<InterviewInterviewer> findByInterview(Interview interview){
		return interviewInterviewerService.findByInterview(interview);
	}
	
	@GetMapping("/allInterviewInterviewerByInterviewer")
	public List<InterviewInterviewer> findByInterviewer(String interviewer){
		return interviewInterviewerService.findByInterviewer(interviewer);
	}

}

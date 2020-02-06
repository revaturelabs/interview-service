package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Interview;
import com.revature.model.InterviewInterviewer;
import com.revature.model.Job;
import com.revature.model.Skill;
import com.revature.model.SkillList;
import com.revature.service.InterviewInterviewerService;
import com.revature.service.JobService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/interviewInterviewer")
public class InterviewInterviewerController {
	
	private InterviewInterviewerService interviewInterviewerService;
	private JobService jobService;

	public InterviewInterviewerController() {
		super();
	}

	@Autowired
	public InterviewInterviewerController(InterviewInterviewerService interviewInterviewerService, JobService jobService) {
		super();
		this.interviewInterviewerService = interviewInterviewerService;
		this.jobService = jobService;
	}
	
	@PostMapping("/interviewInterviewer")
	public InterviewInterviewer findById(int id) {
		return interviewInterviewerService.findById(id);
	}
	
	@PostMapping("/allInterviewInterviewerByInterview")
	public List<InterviewInterviewer> findByInterview(Interview interview){
		return interviewInterviewerService.findByInterview(interview);
	}
	
	@PostMapping("/allInterviewInterviewerByInterviewer")
	public List<InterviewInterviewer> findByInterviewer(String interviewer){
		return interviewInterviewerService.findByInterviewer(interviewer);
	}
	
}

package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Interview;
import com.revature.model.InterviewInterviewer;
import com.revature.repository.InterviewInterviewerRepository;

@Service
public class InterviewInterviewerService {
	
	private InterviewInterviewerRepository interviewInterviewerRepository;
	
	public InterviewInterviewerService() {
	
	}

	@Autowired
	public InterviewInterviewerService(InterviewInterviewerRepository interviewInterviewerRepository) {
			this.interviewInterviewerRepository = interviewInterviewerRepository;
		}

	public InterviewInterviewer findById(int id) {
		return interviewInterviewerRepository.findById(id);
	}

	public List<InterviewInterviewer> findByInterview(Interview interview){
		return interviewInterviewerRepository.findByInterview(interview);
	}
	
	public List<InterviewInterviewer> findByInterviewer(String interviewer){
		return interviewInterviewerRepository.findByInterviewer(interviewer);
	}
}

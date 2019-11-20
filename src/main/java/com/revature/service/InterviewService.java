package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Interview;
import com.revature.repository.InterviewRepository;

/**
 * The service layer (or business logic) for the Interview object.
 * 
 * This file is currently unused.
 * 
 * @author Adriana Long
 */
@Service
@Transactional
public class InterviewService {
	@Autowired
    private InterviewRepository interviewrepo;
    
    public InterviewService(InterviewRepository interviewrepo) {
    	this.interviewrepo = interviewrepo;
    }
    
    public void InsertInterviewInfo(Interview b) {
    	interviewrepo.save(b);
    }
}

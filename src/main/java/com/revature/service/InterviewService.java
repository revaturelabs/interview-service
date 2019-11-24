package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Interview;
import com.revature.repository.InterviewRepository;

/**
 * The service layer (or business logic) for the Interview object.
 * 
 * @author Adriana Long
 */
@Service
@Transactional
public class InterviewService {
	@Autowired
    private InterviewRepository ir;
    
    public InterviewService(InterviewRepository interviewrepo) {
    	this.ir = interviewrepo;
    }
    
    public boolean insertInterviewInfo(Interview i) {
		try {
			ir.save(i);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
    }
    
    public Iterable<Interview> getAllInterviews() {
        return ir.findAll();
    }
}

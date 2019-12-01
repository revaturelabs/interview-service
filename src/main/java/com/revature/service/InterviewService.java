package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Comment;
import com.revature.model.Interview;
import com.revature.repository.InterviewRepository;

/**
 * The service layer (or business logic) for the Interview object.
 * 
 * @author Adriana Long
 */
@Service
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
			return false;
		}
    }
    
    public boolean insertCommentInInterview(int id, Comment c) {
    	try {
    		System.out.println(id);
    		System.out.println(c);
    		Interview i = ir.findById(id);
    		System.out.println(i);
    		//i.getComments().add(c);
    		//System.out.println(i);
    		//ir.save(i);
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

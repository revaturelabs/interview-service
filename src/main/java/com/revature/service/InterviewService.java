package com.revature.service;

import java.util.List;

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
    		Interview i = ir.findById(id);
    		i.getComments().add(c);
    		ir.save(i);
    		return true;
    	} catch (Exception e) {
    		return false;
    	}
    }
    
    public List<Interview> getAllInterviews() {
        return ir.findAll();
    }
    
    public Interview getById(int id) {
        return ir.findById(id);
    }
}

package com.revature.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Interview;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.User;
import com.revature.repository.InterviewRepository;



/**
 * An object representation of our Interview Service.
 * 
 * [TODO] If you are adding on to this or incorporating Spring Data, please add your name to the author list.
 * @author Adriana Long
 * @author 
 */
@Service
@Transactional
public class InterviewService {

    
    private InterviewRepository interviewrepo;
    
    @Autowired
    public InterviewService( InterviewRepository interviewrepo) {
    	this.interviewrepo = interviewrepo;
    }


    public void  InsertInterviewInfo(Interview b) {
        interviewrepo.save(b);
    }
    
//    public Interview findAllInterview(int id){
//    	return interviewrepo.findById(id);
//    }


	
    
    
    
    
    
}

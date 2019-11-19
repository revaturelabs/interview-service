package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Interview;
import com.revature.service.InterviewService;

@RestController
public class InterviewController {

    @Autowired
    private InterviewService interview;

    @GetMapping("/users")
    public void insertInterviewInfo(Interview b) {

    	 
    	 interview.InsertInterviewInfo(b);
    }
    
    
    

  
}

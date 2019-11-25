package com.revature.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Job;
import com.revature.repository.JobRepository;


/**
 * The service layer (or business logic) for the Job object.
 * 
 * @author Adriana Long
 */
@Service
public class JobService {
    @Autowired
    private JobRepository jr;
    
    public JobService(JobRepository jr) {
        this.jr = jr;
    }
    
    public boolean insertJobInfo(Job j) {
        try {
            jr.save(j);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public Iterable<Job> getAllJobs() {
        return jr.findAll();
    }
    
    public List<Job> findByTitle(String title) {
        return jr.findByTitle(title);
    }
    
    public Iterable<Job> findAll() {
        return jr.findAll();
    }
}
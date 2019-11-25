package com.revature.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.repository.JobRepository;
import com.revature.repository.ProfileRepository;


/**
 * 
 * @author Adriana Long
 *
 */
@Service
public class JobService {
    
    
    @Autowired
    private JobRepository jr;
    
    public JobService(JobRepository jr) {
        this.jr = jr;
    }
    
    
    public boolean insertJobInfo(Job p) {
        try {
            jr.save(p);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean updateJobInfo(Job p) {
        try {
            jr.save(p);
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
        // TODO Auto-generated method stub
        return jr.findAll();
    }

    }
    
    

package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Profile;
import com.revature.repository.ProfileRepository;

/**
 * The service layer (or business logic) for the Profile object.
 * 
 * @author Adriana Long
 * @author 
 */
@Service
public class ProfileService {
	@Autowired
    private ProfileRepository pr;
    
    public ProfileService(ProfileRepository pr) {
        this.pr = pr;
    }
    
    public Profile findAllByLastName(String lastName){
        return pr.findByLastName(lastName);
    }
    
    
    public Profile findById(int id) {
    	return pr.findById(id);
    }
    
    public boolean insertProfileInfo(Profile p) {
    	
    	try {
    		System.out.println("made it close");
	    	pr.save(p);
	    	System.out.println("made it this far");
	    	return true;
    	} catch (Exception e) {
    		System.out.println(e);
    		return false;
    	}
    }
    
    public List<Profile> getAllProfiles() {
    	return pr.findAll();
    }
}

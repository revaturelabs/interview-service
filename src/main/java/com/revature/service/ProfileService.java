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
    
    public List<Profile> searchByNameContaining(String lastName){
    	return pr.findByLastNameContaining(lastName);
    }
    
    public Profile findById(int id) {
    	return pr.findById(id);
    }
    
    public boolean insertProfileInfo(Profile p) {
    	try {
	    	pr.save(p);
	    	return true;
    	} catch (Exception e) {
    		return false;
    	}
    }
    
    public Iterable<Profile> getAllProfiles() {
    	return pr.findAll();
    }
}

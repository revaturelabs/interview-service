package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Profile;
import com.revature.repository.ProfileRepository;

/**
 * The service layer (or business logic) for the Profile object.
 * 
 * @author Adriana Long
 * @author 
 */
@Service
@Transactional
public class ProfileService {
	@Autowired
    private ProfileRepository profilerepo;
    
    public ProfileService( ProfileRepository profilerepo) {
        this.profilerepo = profilerepo;
    }
    
    public Profile findAllByLastName(String lastName){
        return profilerepo.findByLastName(lastName);
    }
    
    public void InsertProfileInfo(Profile b) {
    	profilerepo.save(b);
    }
}
   
    
    
    
    

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
   
    private ProfileRepository profileRepository;

    public ProfileService() {
	}
    
    @Autowired
    public ProfileService(ProfileRepository jobRepository) {
        this.profileRepository = jobRepository;
    }

    public Profile findAllByLastName(String lastName) {
        return profileRepository.findByLastName(lastName);
    }

    public Profile findById(int id) {
        return profileRepository.findById(id);
    }

    public boolean insertProfileInfo(Profile profile) {

        try {
            profileRepository.mergeEntity(profile);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }
}

package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    private int pageReturnSize = 10;
    
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
            profileRepository.save(profile);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public List<Profile> getAllProfilesPaged(int page) {
		return profileRepository.findAll(PageRequest.of(page, this.pageReturnSize)).getContent();
	}
	
		//put a % if you want something blank
	public List<Profile> findAllByFullNamePaged(String firstName, String lastName, int page) {
		return profileRepository.findByFirstNameStartsWithIgnoreCaseAndLastNameStartsWithIgnoreCase(firstName, lastName,
				PageRequest.of(page, this.pageReturnSize));
	}

}

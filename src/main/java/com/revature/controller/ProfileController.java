package com.revature.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Profile;
import com.revature.service.ProfileService;

/**
 * The main controller for obtaining information about an Interview
 * 
 * @author Adriana Long
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/profiles")
public class ProfileController {

    private ProfileService profileService;
    
    public ProfileController() {
	}
    
    

    @Autowired
    public ProfileController(ProfileService profileService) {
		super();
		this.profileService = profileService;
	}



	@PostMapping("/saveProfile")
    @Transactional
    public boolean insertProfileInfo(@RequestBody Profile profile) {
        return profileService.insertProfileInfo(profile);
    }

    @GetMapping("/allProfiles")
    public List<Profile> getAll() {
        return profileService.getAllProfiles();
    }
}
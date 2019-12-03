package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Profile;
import com.revature.service.ProfileService;

/**
 * The main controller for obtaining information about an Interview
 * @author Adriana Long
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/profiles")
public class ProfileController {
    @Autowired
    private ProfileService ps;
    
	@Autowired
	private AuthInterface ai;
    
    @PostMapping("/saveProfile")
    public boolean insertProfileInfo(@RequestBody Profile profile) {
    		return ps.insertProfileInfo(profile);
    }
    
    @GetMapping("/allProfiles")
    public Iterable<Profile> getAll() {
    		return ps.getAllProfiles();
    }
}
package com.revature.controllers;

import java.util.List;

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
    
    @PostMapping("/saveProfile")
    public boolean insertProfileInfo(@RequestBody Profile profile) {
    	return ps.insertProfileInfo(profile);
    }
    
    @GetMapping("/allProfiles")
    public Iterable<Profile> getAll() {
    	return ps.getAllProfiles();
    }
    
    @GetMapping("/searchProfiles")
    public List<Profile> searchProfiles(@RequestHeader String lastName){
    	return ps.searchAllByLastName(lastName);
    }
    
//    @GetMapping("/searchLikeProfiles")
//    public List<Profile> searchLikeProfiles(@RequestHeader String lastName){
//    	return ps.searchAllByLastName2(lastName);
//    }
    
    @GetMapping("/searchContainProfiles")
    public List<Profile> searchContainProfiles(@RequestHeader String lastName){
    	return ps.searchByNameContaining(lastName);
    }
}
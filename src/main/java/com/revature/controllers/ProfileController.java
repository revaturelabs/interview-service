package com.revature.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.model.Profile;
import com.revature.service.ProfileService;
@RestController
public class ProfileController {
	
	
	
	
    @Autowired
    private ProfileService profile;
    @GetMapping("/profile")
    public void insertProfileInfo(Profile b) {
         
        profile.InsertProfileInfo(b);;
    }
    
    
    
  
}
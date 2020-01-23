package com.revature.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Profile;
import com.revature.service.ProfileService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/profiles")
/** The main controller for obtaining information about a candidate.
 * @author Adriana Long */
public class ProfileController {

	/** A profile service object that performs the business logic for the profile class. */
    private ProfileService profileService;
    
    /** Creates a new profile service, setting its properties to their default values. */
    public ProfileController() {
	}

    @Autowired
    /** Creates a new profile service, setting its properties to the provided values.
     * @param profileService A profile service object that performs the business logic
     for the profile class. */
    public ProfileController(ProfileService profileService) {
		super();
		this.profileService = profileService;
	}

	@PostMapping("/saveProfile")
    @Transactional
    /** Transactionally saves a candidate profile to the database, in response to an HTTP Post request 
     at the uri "/profiles/saveProfile". 
     * @param profile The candidate profile being saved.
     * @return True if the profile was saved successfully, and false if the profile was not saved. */
    public boolean insertProfileInfo(@RequestBody Profile profile) {
        return profileService.insertProfileInfo(profile);
    }

    @GetMapping("/allProfiles")
    /** Returns a list of all candidate profiles in the database, in response to an HTTP Get request
     at the uri "/profiles/allProfiles".
     * @return A list of all candidate profiles in the database. */
    public List<Profile> getAll() {
        return profileService.getAllProfiles();
    }
    
 	@GetMapping("/allProfiles/{page}")
    /** Returns a list of all candidate profiles on a given page, in response to an HTTP Get request
     at the uri "/profiles/allProfiles/{page}" where {page} refers to an integer identifying 
	 the page to search for profiles.
     * @param page An integer identifier the page to search for profiles.
     * @return A list of all candidate profiles on a given page. */
	public List<Profile> getAllPaged(@PathVariable int page) {
		return profileService.getAllProfilesPaged(page);
	}

	@GetMapping("/searchProfiles/{firstName}/{lastName}/{page}")
    /** Retrieves a list containing the profiles for all candidates on a given page whose first name starts with
    a provided string, and whose last name starts with another provided string, in response to an HTTP Get request
    at the uri "/profiles/searchProfiles/{firstName}/{lastName}/{page}" where {firstName} refers to the start
    of their first name, {lastName} refers to the start of their last name, and {page} refers to an integer 
    identifying the page to search for profiles. Upper and lower case are ignored for both the firstName and
    lastName parameters.
    * @param firstName A string that will filter out all candidates whose first names do not start with that string.
     To search for profiles with an empty first name, use "%" as the argument.
    * @param lastName A string that will filter out all candidates whose last names do not start with that string.
     To search for profiles with an empty last name, use "%" as the argument.
    * @param page The page that will be searched for matching candidates. Any candidate outside this page will
	 not be returned in the results list, even if they fulfill the other search criteria.
    * @return A list containing the profiles for all candidates on a given page whose first name starts with
    a provided string, and whose last name starts with another provided string. */
	public List<Profile> searchByFullNamePaged(@PathVariable String firstName, @PathVariable String lastName,
			@PathVariable int page) {
		return profileService.findAllByFullNamePaged(firstName, lastName, page);
	}
}
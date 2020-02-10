package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.revature.model.Profile;
import com.revature.repository.ProfileRepository;

/** The service layer (or business logic) for the Profile object.
 * @author Adriana Long */
@Service
public class ProfileService {

	/** A CRUD repository that connects this profile service to the database. */
    private ProfileRepository profileRepository;

    /** The number of jobs to return on each page. Default is 10. */
    private int pageReturnSize = 10;
    
    /** Creates a new profile service, with its properties set to their default values. */
    public ProfileService() {
	}
    
    @Autowired
    /** Creates a new profile service, setting its profile repository to an existing repository.
     * @param jobRepository A CRUD repository that connects this profile service to the database. */
    public ProfileService(ProfileRepository jobRepository) {
        this.profileRepository = jobRepository;
    }

    /** Retrieves the profile of the first candidate in the database whose last name matches the provided name.
	 Returns null if no such candidate is found.
	 * @param lastName The last name of the candidate.
	 * @return The profile of the first candidate in the database whose last name matches the provided name. */
    public Profile findAllByLastName(String lastName) {
        return profileRepository.findByLastName(lastName);
    }

    /** Retrieves the profile of the candidate in the database whose ID matches the provided number.
    Returns null if no such candidate is found.
    * @param id The integer that uniquely identifies the candidate. 
    * @return The profile of the candidate in the database whose ID matches the provided number, 
    or null if no such candidate is found. */
    public Profile findById(int id) {
        return profileRepository.findById(id);
    }

    /** Saves a candidate profile to the database.
     * @param profile The candidate profile being saved.
     * @return True if the profile was saved successfully, and false if the profile was not saved. */
    public boolean insertProfileInfo(Profile profile) {
        try {
            profileRepository.save(profile);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /** Returns a list of all candidate profiles in the database.
     * @return A list of all candidate profiles in the database. */
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    /** Returns a list of all candidate profiles on a given page. 
     * @param page An integer identifier the page to search for profiles.
     * @return A list of all candidate profiles on a given page. */
    public List<Profile> getAllProfilesPaged(int page) {
		return profileRepository.findAll(PageRequest.of(page, this.pageReturnSize)).getContent();
	}
    
    /** Returns a filtered list of all candidate profiles on a given page. 
     * @param given profile search value to filter with.
     * @param page An integer identifier the page to search for profiles.
     * @return A list of filtered candidate profiles on a given page. */
    public List<Profile> getFilterProfilesPaged(String searchValue, int page) {
		return profileRepository.findByFirstNameStartsWithIgnoreCaseOrLastNameStartsWithIgnoreCaseOrLocationStartsWithIgnoreCaseOrEmailAddressStartsWithIgnoreCase(
				searchValue, searchValue, searchValue, searchValue, PageRequest.of(page, this.pageReturnSize));
	}
	
    /** Retrieves a list containing the profiles for all candidates on a given page whose first name starts with
    a provided string, and whose last name starts with another provided string.
    * @param firstName A string that will filter out all candidates whose first names do not start with that string.
     To search for profiles with an empty first name, use "%" as the argument.
    * @param lastName A string that will filter out all candidates whose last names do not start with that string.
     To search for profiles with an empty last name, use "%" as the argument.
    * @param page The page that will be searched for matching candidates. Any candidate outside this page will
	 not be returned in the results list, even if they fulfill the other search criteria.
    * @return A list containing the profiles for all candidates on a given page whose first name starts with
    a provided string, and whose last name starts with another provided string. */
	public List<Profile> findAllByFullNamePaged(String firstName, String lastName, int page) {
		return profileRepository.findByFirstNameStartsWithIgnoreCaseAndLastNameStartsWithIgnoreCase(firstName, lastName,
				PageRequest.of(page, this.pageReturnSize));
	}

	public List<Profile> findBySkills(int[] skillIds, int page){
		return profileRepository.findBySkills(skillIds, PageRequest.of(page, this.pageReturnSize));
	}
}

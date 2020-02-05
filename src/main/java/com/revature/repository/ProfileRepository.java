package com.revature.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Profile;

/** Representation of the profile repository
 * @author Adriana Long
 * @author Brian Abajah */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
	/** Retrieves the profile of the first candidate in the database whose last name matches the provided name.
	 Returns null if no such candidate is found.
	 * @param lastName The last name of the candidate.
	 * @return The profile of the first candidate in the database whose last name matches the provided name. */
    Profile findByLastName(String lastName);

    /** Retrieves the profile of the first candidate in the database whose first name matches the provided name.
     Returns null if no such candidate is found.
     * @param firstName The first name of the candidate. 
     * @return The profile of the first candidate in the database whose first name matches the provided name. */
    Profile findByFirstName(String firstName);

    /** Retrieves the profile of the candidate in the database whose ID matches the provided number.
     Returns null if no such candidate is found.
     * @param id The integer that uniquely identifies the candidate. 
     * @return The profile of the candidate in the database whose ID matches the provided number, 
     or null if no such candidate is found. */
    Profile findById(int id);

    /** Retrieves a list containing the profiles for all candidates whose last names match the provided string.
     * @param lastName The last name of the candidates.
     * @return A list containing the profiles for all candidates whose last names match the provided string. */
    List<Profile> findByLastNameOrderByLastNameAsc(String lastName);

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
    List<Profile> findByFirstNameStartsWithIgnoreCaseAndLastNameStartsWithIgnoreCase(String firstName, String lastName, Pageable page);
    
    /** Retrieves a list containing the profiles for all candidates whose first names starts with provided value.
     * @param searchValue 
     * @param using search value to filter first name start with
     * @param using search value to filter last name start with
     * @param using search value to filter location start with
     * @param using search value to filter emailAddress start with
     * @return A list containing the profiles for filtered candidates */
    List<Profile> findByFirstNameStartsWithIgnoreCaseOrLastNameStartsWithIgnoreCaseOrLocationStartsWithIgnoreCaseOrEmailAddressStartsWithIgnoreCase(
    		String firstName, String lastName, String location, String emailAddress, Pageable page);
	
    
}

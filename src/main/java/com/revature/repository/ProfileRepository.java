package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Profile;

/**
 * Representation of the profile repository
 * 
 * @author Adriana Long
 * @author Brian Abajah
 */
public interface ProfileRepository extends JpaRepository<Profile, Integer>{
    Profile findByLastName(String lastName);
    Profile findByFirstName(String firstName);
    
    //@Query("SELECT firstName, lastName FROM profile WHERE firstName + ' ' + lastName LIKE %:keyword%")
    //List<Profile> search(@Param("keyword") String keyword);
}

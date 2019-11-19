package com.revature.repository;

import org.springframework.data.repository.CrudRepository;
import com.revature.model.Profile;

/**
 * Representation of the profile repository
 * 
 * @author Adriana Long
 * @author Brian Abajah
 */
public interface ProfileRepository extends CrudRepository <Profile, Long>{
    Profile findByLastName(String lastName);
    Profile findByFirstName(String firstName);
}

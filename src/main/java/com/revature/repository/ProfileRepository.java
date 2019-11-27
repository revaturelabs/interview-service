package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Profile;

/**
 * Representation of the profile repository
 * 
 * @author Adriana Long
 * @author Brian Abajah
 */

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>{
    Profile findByLastName(String lastName);
    Profile findByFirstName(String firstName);
    List<Profile> findByLastNameOrderByLastNameAsc(String lastName);
    
//    @Query("SELECT lastname FROM profiles WHERE lastname LIKE %?1%")
//    List<Profile> findByLastName2(String lastname);
    
    List<Profile> findByLastNameContaining(String lastname);
}

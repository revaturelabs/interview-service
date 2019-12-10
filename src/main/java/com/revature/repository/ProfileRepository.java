package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Profile;

/**
 * Representation of the profile repository
 * 
 * @author Adriana Long
 * @author Brian Abajah
 */

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>, CustomProfileRepo{
    Profile findByLastName(String lastName);
    Profile findByFirstName(String firstName);
    Profile findById(int id);
    List<Profile> findByLastNameOrderByLastNameAsc(String lastName);
 
}

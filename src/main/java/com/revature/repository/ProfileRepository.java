package com.revature.repository;
import org.springframework.data.repository.CrudRepository;
import com.revature.model.Interview;
import com.revature.model.Profile;
import java.util.List;
import java.util.Optional;
/**
 * Representation of the profile repository
 * 
 * [TODO] If you are adding on to this or incorporating Spring Data, please add your name to the author list.
 * @author Adriana Long
 * @author 
 */
public interface ProfileRepository extends CrudRepository <Profile, Long>{
    
    List<Profile> findByLastName(String lastName);
    
    Profile findByFirstName(String firstName);
    
}

package com.revature.service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.revature.model.Interview;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.User;
import com.revature.repository.ProfileRepository;

/**
 * An object representation of our Interview model.
 * 
 * [TODO] If you are adding on to this or incorporating Spring Data, please add your name to the author list.
 * @author Adriana Long
 * @author 
 */
@Service
@Transactional
public class ProfileService {
    
    private ProfileRepository profilerepo;
    
    @Autowired
    public ProfileService( ProfileRepository profilerepo) {
        this.profilerepo = profilerepo;
    }
   
    
    public List<Profile> findAllByLastName(String lastName){
        return profilerepo.findByLastName(lastName);
    }
    
    public void InsertProfileInfo(Profile b) {
        profilerepo.save(b);
    }
    
  
}
   
    
    
    
    

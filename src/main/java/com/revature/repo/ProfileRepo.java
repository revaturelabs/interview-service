package com.revature.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.model.Profile;



@Transactional
@Repository("profileRepo")




public class ProfileRepo {
	
	
	 static {
	        try {
	            Class.forName("org.postgresql.Driver");
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	//  
	    private SessionFactory sesFact;
	    
	    @Autowired
	    public ProfileRepo(SessionFactory sesFact) {
	        super();
	        this.sesFact = sesFact;
	    }
	    
	    
	    public void setSessoinFactory(SessionFactory sessionFactory) {
	        this.sesFact=sessionFactory;
	    }
	    
	    public void InsertProfileInfo(Profile b) {
	        
	        sesFact.getCurrentSession().save(b);        
	    }
	    
	    
	    public List<Profile> getAllPosts(){
	        
	    	 Session ses = sesFact.getCurrentSession();  
	         String hql = "from Profile";
	         return ses.createQuery(hql, Profile.class).list();
	     }
	    
	    
	
	
	
	

}

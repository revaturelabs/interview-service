package com.revature.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.model.Interview;
import com.revature.model.Profile;

@Transactional
@Repository("interviewRepo")
public class SkillRepo {

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
	    public SkillRepo(SessionFactory sesFact) {
	        super();
	        this.sesFact = sesFact;
	    }
	    
	    
	    public void setSessoinFactory(SessionFactory sessionFactory) {
	        this.sesFact=sessionFactory;
	    }
	    
	    public void InsertProfileInfo(Profile b) {
	        
	        sesFact.getCurrentSession().save(b);        
	    }
	    
	    
	    public List<Interview> getAllPosts(){
	        
	    	 Session ses = sesFact.getCurrentSession();  
	         String hql = "from Interview";
	         return ses.createQuery(hql, Interview.class).list();
	     }

}

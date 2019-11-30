package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Skill;
import com.revature.repository.SkillRepository;

/**
 * The service layer (or business logic) for the Skill object.
 * 
 * @author Joseph F Davis
 * @author John Thaddeus Kelly
 */
@Service
public class SkillService {
	@Autowired
	SkillRepository sr;
	
	public Iterable<Skill> getAll(){
		return sr.findAll();
	}
	
	public boolean insertSkill(Skill s) {
		 try {
			 sr.save(s); 
	            return true;
	        } catch (Exception e) {
	            System.out.println(e);
	            return false;
	        }
	}
	
	public Skill findSkill(String s) {
		return sr.findByTitle(s);
	}
	
	
}

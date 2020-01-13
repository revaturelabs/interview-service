package com.revature.service;

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

	SkillRepository skillRepository;

	public SkillService() {
	}
	
	@Autowired
	public SkillService(SkillRepository skillRepository) {
		super();
		this.skillRepository = skillRepository;
	}


	public Iterable<Skill> getAll() {
		return skillRepository.findAll();
	}

	public boolean insertSkill(Skill skill) {
		try {
			skillRepository.save(skill);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public Skill findSkill(String title) {
		return skillRepository.findByTitle(title);
	}
}

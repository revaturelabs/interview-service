package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	private int pageReturnSize = 10;

	public SkillService() {
	}
	
	@Autowired
	public SkillService(SkillRepository skillRepository) {
		super();
		this.skillRepository = skillRepository;
	}

	public Skill getById(int id)
	{
		return skillRepository.findById(id);
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

	public List<Skill> findSkill(String title) {
		return skillRepository.findByTitleStartsWithIgnoreCase(title);
	}
	
	public List<Skill> findSkillPaged(String title,	int page) {
		return skillRepository.findByTitleStartsWithIgnoreCase(title, PageRequest.of(page, this.pageReturnSize ));
	}
}

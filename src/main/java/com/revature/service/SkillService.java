package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.revature.model.Skill;
import com.revature.repository.SkillRepository;

/** The service layer (or business logic) for the Skill object.
 * @author Joseph F Davis
 * @author John Thaddeus Kelly */
@Service
public class SkillService {

	/** A CRUD repository that links this skill service to the database. */
	SkillRepository skillRepository;
	
	/** The number of skills to return on each page. Default is 10. */
	private int pageReturnSize = 10;

	/** Creates a new skill service, with all properties set to their default values. */
	public SkillService() {
	}
	
	@Autowired
	/** Creates a new skill service, setting its skill repository to an existing repository.
	 * @param skillRepository A CRUD repository that links this skill service to the database. */
	public SkillService(SkillRepository skillRepository) {
		super();
		this.skillRepository = skillRepository;
	}

	/** Retrieves the skill from the database whose ID matches the provided number.
	 Returns null if no such skill is found.
	 * @param id The integer that uniquely identifies the skill.
	 * @return The skill from the database whose ID matches the provided number,
	 or null if no such skill is found. */
	public Skill getById(int id) {
		return skillRepository.findById(id);
	}

	/** Returns an iterable data structure containing all skills in the database. 
	 * @return An iterable data structure containing all skills in the database. */
	public Iterable<Skill> getAll() {
		return skillRepository.findAll();
	}

	/** Saves a skill to the database.
	 * @param skill The skill being saved.
	 * @return True if the skill was saved successfully, and false if the skill was not saved. */
	public boolean insertSkill(Skill skill) {
		try {
			skillRepository.save(skill);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	/** Returns a list of all skills whose names start with the provided string,
	 ignoring upper and lower case.
	 * @param title A string that will filter out all skills whose names do not start with that string,
	 ignoring upper and lower case.
	 * @return A ist of all skills whose names start with the provided string,
	 ignoring upper and lower case. */
	public List<Skill> findSkill(String title) {
		return skillRepository.findByTitleStartsWithIgnoreCase(title.toLowerCase());
	}
	
	/** Returns a list of skills on a given page whose names start with the provided string,
	 ignoring upper and lower case.
	 * @param title A string that will filter out all skills whose names do not start with that string,
	 ignoring upper and lower case.
	 * @param page The page that will be searched for matching skills, Any skills outside this page will
	 not be returned in the results list, even if their names tart with the string provided in the title parameter.
	 * @return A list of skills on a given page whose names start with the provided string,
	 ignoring upper and lower case. */
	public List<Skill> findSkillPaged(String title,	int page) {
		return skillRepository.findByTitleStartsWithIgnoreCase(title.toLowerCase(), PageRequest.of(page, this.pageReturnSize ));
	}
}

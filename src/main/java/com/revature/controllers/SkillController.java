package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Skill;
import com.revature.repository.SkillRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/skills")
public class SkillController {
	
	@Autowired
	private SkillRepository sr;
	
	public SkillRepository getRepository() {
		return sr;
	}

	@Autowired
	public void setRepository(SkillRepository sr) {
		this.sr = sr;
	}
	
	/**
	 * @author Seacriest Brown
	 * 		Adding skills to the database.
	 * @return String confirming data entry
	 */
	@GetMapping(value="/skill")
	public String save() {
//		Skill skl = new Skill(0,"System Admin");
//		sr.save(skl);
//		return skl.getTitle() +" was added to the database"
		return "No skills to add at the moment";
	}
	
	/**
	 * @author Seacriest Brown
	 * 		Retrieve all skills
	 * @return List of skills
	 */
	@GetMapping(value="/allskills")
	public @ResponseBody List<Skill> allSkills(){
		List<Skill> list = new ArrayList<>();
		for(Skill sk : sr.findAll()) {
			list.add(sk);
		}
		return list;
	}
	
	/**
	 * @author Seacriest Brown
	 * 		Retrieve selected skill by id
	 * @return The skill that matches the id
	 */
	@GetMapping(value="/skill/{id}")
	public Skill getBySkill(@PathVariable("id") int id) {
		for(Skill sk : sr.findAll()) {
			if(sk.getId()==id)
				return sk;
		}
		return null;
	}
}

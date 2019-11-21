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
	
	/**
	 * Retrieve all skills
	 * 
	 * @author Seacriest Brown
	 * @return List of skills
	 */
	@GetMapping(value="/allSkills")
	public @ResponseBody List<Skill> allSkills(){
		List<Skill> list = new ArrayList<>();
		for(Skill sk : sr.findAll()) {
			list.add(sk);
		}
		return list;
	}
	
	/**
	 * Retrieve selected skill by id
	 * 
	 * @return The skill that matches the id
	 * @author Seacriest Brown
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

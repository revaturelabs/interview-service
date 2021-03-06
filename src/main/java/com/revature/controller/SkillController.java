package com.revature.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Skill;
import com.revature.repository.SkillRepository;
import com.revature.service.SkillService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/skills")
public class SkillController {

	private SkillRepository skillRepository;

	private SkillService skillService;

	public SkillController() {
	}
	
	@Autowired
	public SkillController(SkillRepository skillRepository, SkillService skillService) {
		super();
		this.skillRepository = skillRepository;
		this.skillService = skillService;
	}


	/**
	 * Retrieve all skills
	 * 
	 * @author Seacriest Brown
	 * @return List of skills
	 */
	@GetMapping
	public @ResponseBody List<Skill> allSkills() {
		List<Skill> list = new ArrayList<>();
		for (Skill skill : skillRepository.findAll()) {
			list.add(skill);
		}
		return list;
	}

	/**
	 * Retrieve selected skill by id
	 * 
	 * @return The skill that matches the id
	 * @author Seacriest Brown
	 */
	@GetMapping(value = "/{id}")
	public Skill getBySkill(@PathVariable("id") int id) {
		return skillService.getById(id);
	}

	/**
	 * @author Joseph F Davis
	 * @param skill The skill to insert
	 */
	@PostMapping
	public boolean insertSkill(@RequestBody Skill skill) {
		return skillService.insertSkill(skill);
	}


	/**
	 * @author Joseph F Davis
	 * @param title
	 * @return skill by title
	 */
	@GetMapping(value = "/title/{Title}")
	public List<Skill> getSkills(@PathVariable("Title") String title) {
		return skillService.findSkill(title);
	}

	@GetMapping(value = "/title/{Title}/{page}")
	public List<Skill> getSkills(@PathVariable("Title") String title, @PathVariable int page) {
		return skillService.findSkillPaged(title, page);
	}
	
}
package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	@Autowired
	private SkillRepository sr;
	
	@Autowired
	private SkillService sk;
	
	@Autowired
	private AuthInterface ai;
	
	/**
	 * Retrieve all skills
	 * 
	 * @author Seacriest Brown
	 * @return List of skills
	 */
	@GetMapping(value="/allSkills")
	public @ResponseBody List<Skill> allSkills(@RequestHeader(name="auth") String token) {
		if (ai.authorize(token)) {
			List<Skill> list = new ArrayList<>();
			for(Skill sk : sr.findAll()) {
				list.add(sk);
			}
			return list;
		} else {
			return null;
		}
	}
	
	/**
	 * Retrieve selected skill by id
	 * 
	 * @return The skill that matches the id
	 * @author Seacriest Brown
	 */
	@GetMapping(value="/skill/{id}")
	public Skill getBySkill(@RequestHeader(name="auth") String token, @PathVariable("id") int id) {
		if (ai.authorize(token)) {
			for(Skill sk : sr.findAll()) {
				if(sk.getId()==id) {
					return sk;
        }
			}
			return null;
		} else {
			return null;
		}
	}
	
	/**
	 * @author Joseph F Davis
	 * @param s The skill to insert
	 */
	@PostMapping(value= "/insertSkill")
	public void insertSkill(@RequestHeader(name="auth") String token, @RequestBody Skill s) {
		if (ai.authorize(token)) {
			sk.insertSkill(s);
		}
	}
	
	/**
	 * @author Joseph F Davis
	 * @return All skills through the service layer
	 */
	@GetMapping(value="/getSkills")
	public Iterable<Skill> getSkills(@RequestHeader(name="auth") String token) {
		if (ai.authorize(token)) {
			return sk.getAll();
		} else {
			return null;
		}
	}
	
	/**
	 * @author Joseph F Davis
	 * @param title
	 * @return skill by title
	 */
	@GetMapping(value="/getskill/{Title}")
	public Skill getSkills(@RequestHeader(name="auth") String token, @PathVariable("Title") String title) {
		if (ai.authorize(token)) {
			return sk.findSkill(title);
		} else {
			return null;
		}
	}
}

package com.revature.model;

import java.util.List;

public class SkillList {

	private List<Skill> skills;
	
	

	public SkillList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SkillList(List<Skill> skills) {
		super();
		this.skills = skills;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	
}

package com.revature.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.h2.engine.Database;
import org.h2.engine.Session;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.controller.SkillController;
import com.revature.model.Skill;

/*
 * Tester class built off of existing tester for SkillController. Utilizes Mockito and H2 database to test functionality.
 * @author: redc
 * TODO: Use Hibernate to plug in H2; Finish implementation & testing of methods.
 */

public class SkillControllerTest {
	
	//Mockito starter stuff.
	Skill skillA = Mockito.mock(Skill.class);
	Skill skillB = Mockito.mock(Skill.class);
	Skill skillC = Mockito.mock(Skill.class);
	List<Skill> skillList;
	SkillController skillCon = Mockito.mock(SkillController.class);
	
	//Pulls from H2.
	Session ses;
	Database db = new Database(null, null);
	
	// Cannibalized from old tester. Modifed to fit constructor. 
	//Skill skill = new Skill(1, "Spring Boot Test"); 
	//Skill skill2 = new Skill(2, "Java"); 
	//Skill skill3 = new Skill(3, "SQL");

	@Before
	public void setUp() throws Exception {
		skillA.setId(0);
		skillA.setTitle("Spring Boot Test");
		skillList.add(skillA);
		
		skillB.setId(1);
		skillA.setTitle("Java");
		skillList.add(skillB);
		
		skillA.setId(2);
		skillA.setTitle("SQL");
		skillList.add(skillC);
		
		//args: Database, User, int.
		ses = new Session(null, null, 0);
	}

	//Testing that correct number of skills comes back, then
	@Test
	public void testAllSkills() {
		System.out.println(skillList.toString());
		Mockito.when(skillCon.allSkills());
		assertEquals(3, skillCon.allSkills().size());
	}

	//Testing that id given as arg returns correct skill.
	@Test
	public void testGetBySkill() {
		System.out.println("in getBySkull");
		Mockito.when(skillCon.getBySkill(1));
		assertEquals(skillCon.getBySkill(1), skillList.get(1));
	}

	// Test insertion. Create skill, and ensure that a value from DB is returned. (Query by name?)
	@Test
	public void testInsertSkill() {
		Skill testSkill = Mockito.mock(Skill.class);
		testSkill.setId(3);
		testSkill.setTitle("Assembly");
		Mockito.when(skillCon.insertSkill(testSkill));
		assertEquals(skillCon.getBySkill(3), "Assembly");
	}

	// Gets all skills through service layer. How to differentiate from allSkils tester?
	@Test
	public void testGetSkills() {
		fail("Not yet implemented");
	}

	//Gets skill by title.
	@Test
	public void testGetSkillsString() {
		System.out.println("in getSkillByString");
		Mockito.when(skillCon.getSkills("SQL")).thenReturn(skillB);
		assertEquals(skillCon.getSkills("SQL"), skillList.get(2));	}
}

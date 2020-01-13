package com.revature.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.revature.controller.SkillController;
import com.revature.model.Skill;
import com.revature.repository.SkillRepository;
import com.revature.service.SkillService;

/*
 * Tester class built off of existing tester for SkillController. Utilizes Mockito and H2 database to test functionality.
 * @author: redc
 * TODO: Use Hibernate to plug in H2; Finish implementation & testing of methods.
 */

public class SkillControllerTest {
	
	//Mockito starter stuff.
	@Rule
	public MockitoRule mockRule = MockitoJUnit.rule();
	
	@Mock
	SkillRepository skillRep;
	
	@Mock
	SkillService skillServ;
	
	@InjectMocks
	SkillController skillCon;

	
	
	
	//Pulls from H2. Integration testing. Too far?
	/*
	 * Session ses; Database db = new Database(null, null);
	 */
	
	// Cannibalized from old tester. Modifed to fit constructor. 
	//Skill skill = new Skill(1, "Spring Boot Test"); 
	//Skill skill2 = new Skill(2, "Java"); 
	//Skill skill3 = new Skill(3, "SQL");

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		skillCon = new SkillController(skillRep, skillServ);
		
		

		
		//args: Database, User, int.
		//ses = new Session(null, null, 0);
	}

	//Testing that correct number of skills comes back, then
	@Test
	public void testAllSkills() {
		System.out.println("in allSkills");
		
		
		//Config
		
		List<Skill> skillList = new ArrayList<Skill>();
		Skill skillA = Mockito.mock(Skill.class);
		skillA.setId(0);
		skillA.setTitle("Spring Boot Test");
		skillList.add(skillA);
		
		Skill skillB = Mockito.mock(Skill.class);
		skillB.setId(1);
		skillB.setTitle("Java");
		skillList.add(skillB);

		
		Skill skillC = Mockito.mock(Skill.class);
		skillC.setId(2);
		skillC.setTitle("SQL");
		skillList.add(skillC);
		
		when(skillRep.findAll()).thenReturn(skillList);
		
		//Tester
		
		List<Skill> reqList = skillCon.allSkills();
		assertEquals(3, reqList.size());
		verify(skillRep, times(1)).findAll();
	}

	//Testing that id given as arg returns correct skill. NOT EVEN IN SERVICE. XD
	@Test
	public void testGetBySkill() {
		System.out.println("in getBySkull");
		fail("Method not defined in Service.");
	}

	// Test insertion. Create skill, and ensure that a value from DB is returned. (Query by name?)
	@Test
	public void testInsertSkill() {
		System.out.println("in InsertSkill");
		
		//Config
		Skill testSkill = Mockito.mock(Skill.class);
		testSkill.setId(3);
		testSkill.setTitle("Assembly");
		Mockito.when(skillRep.save(testSkill)).thenReturn(testSkill);
		
		//Tester
		skillCon.insertSkill(testSkill);
		verify(skillRep, times(1)).save(testSkill);
		
	}

	// Gets all skills through service layer. How to differentiate from allSkils tester?
	@Test
	public void testGetSkills() {
		System.out.println("in GetSkills");
		fail("Not yet implemented");
	}

	//Gets skill by title.
	@Test
	public void testGetSkillsString() {
		System.out.println("in getSkillByString");
		
		//Config
		Skill testSkill = Mockito.mock(Skill.class);
		testSkill.setId(1);
		testSkill.setTitle("Java");
		
		when(skillRep.findByTitle("Java")).thenReturn(testSkill);
		
		//Tester
		Skill reqSkill = skillCon.getSkills("Java");
		assertEquals(reqSkill.getClass(), testSkill.getClass());
		verify(skillRep, times(1)).findByTitle("Java");
	}
}

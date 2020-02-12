package com.revature.controllers;

import static org.junit.Assert.assertEquals;
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

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		skillCon = new SkillController(skillRep, skillServ);

	}

	@Test
	public void testAllSkills() {
		System.out.println("in allSkills");

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
		
		List<Skill> reqList = skillCon.allSkills();
		assertEquals(3, reqList.size());
		verify(skillRep, times(1)).findAll();
	}

	@Test
	public void testInsertSkill() {
		System.out.println("in InsertSkill");
		
		//Config
		Skill testSkill = Mockito.mock(Skill.class);
		testSkill.setId(3);
		testSkill.setTitle("Assembly");
		Mockito.when(skillServ.insertSkill(testSkill)).thenReturn(true);
		
		//Tester
		skillCon.insertSkill(testSkill);
		verify(skillServ, times(1)).insertSkill(testSkill);
		
	}

	@Test
	public void testGetSkillsString() {
		System.out.println("in getSkillByString");
		
		//Config
		Skill testSkill = Mockito.mock(Skill.class);
		testSkill.setId(1);
		testSkill.setTitle("Java");
		List<Skill> testList = new ArrayList<>();
		testList.add(testSkill);
		when(skillServ.findSkill("Java")).thenReturn(testList);
		
		//Tester
		Skill reqSkill = skillCon.getSkills("Java").get(0);
		assertEquals(reqSkill, testSkill);
		verify(skillServ, times(1)).findSkill("Java");
	}
}

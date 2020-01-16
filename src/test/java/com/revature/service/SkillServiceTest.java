package com.revature.service;

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

import com.revature.model.Skill;
import com.revature.repository.SkillRepository;
import com.revature.service.SkillService;

/*
 * Tester for SkillService class.
 * 
 * @AUTHOR: redc
 * @CREATED: 13JAN2020
 */

public class SkillServiceTest {

	//Mockito starter stuff.
	@Rule
	public MockitoRule mockRule = MockitoJUnit.rule();
	
	@Mock
	SkillRepository skillRep;
	
	@InjectMocks
	SkillService skillServ;
	
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
	}

	//CONSTRUCTORS
	
	@Test
	public void testSkillService() {
		System.out.println("in SkillService()");
		
		SkillService testServ = new SkillService();
		if (testServ.getClass() != SkillService.class)
		{
			fail("Constructor not working.");
		}	
	}

	@Test
	public void testSkillServiceSkillRepository() {
		System.out.println("in SkillService(SkillRepository)");
		
		SkillService testServ = new SkillService(skillRep);
		if (testServ.getClass() != SkillService.class)
		{
			fail("Not yet implemented");
		}	
		
	}

	//METHODS
	
	@Test
	public void testGetAll() {
		System.out.println("in getAll");
		
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
		
		Iterable<Skill> reqList = skillServ.getAll();
		
		assertEquals(reqList, skillList);
		verify(skillRep, times(1)).findAll();
	}

	@Test
	public void testInsertSkill() {
		System.out.println("in insertSkill");

		//Config
		Skill testSkill = Mockito.mock(Skill.class);
		testSkill.setId(3);
		testSkill.setTitle("Assembly");
		when(skillRep.save(testSkill)).thenReturn(testSkill);
				
		//Tester
		skillServ.insertSkill(testSkill);
		verify(skillRep, times(1)).save(testSkill);
				
	}

	@Test
	public void testFindSkill() {
		System.out.println("in findSkill");
		
		Skill testSkill = Mockito.mock(Skill.class);
		testSkill.setId(2);
		testSkill.setTitle("SQL");
		when(skillRep.findByTitle("SQL")).thenReturn(testSkill);

		//Tester
		//skillServ.findSkill("SQL");
		assertEquals(skillServ.findSkill("SQL"), testSkill);
		verify(skillRep, times(1)).findByTitle("SQL");
	}

}

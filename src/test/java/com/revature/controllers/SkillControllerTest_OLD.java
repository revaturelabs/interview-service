
package com.revature.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.controller.SkillController;
import com.revature.model.Skill;

/*
 * @SpringBootTest(classes = { SkillController.class }, webEnvironment =
 * SpringBootTest.WebEnvironment.RANDOM_PORT)
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @EnableJpaRepositories("com.revature.repository")
 * 
 * @EntityScan("com.revature.model")
 * 
 * @ComponentScan("com.revature.service")
 */
  
 /* @EnableAutoConfiguration // @EnableFeignClients(clients = {
  AuthInterface.class })*/
  
/*  @TestPropertySource(locations = "classpath:application-test.properties")
  public class SkillControllerTest_OLD {*/
 

/**
	 * JUnit testing for the Skill Controller object
	 * 
	 * @author John Thaddeus Kelly
	 */
		 /* @Autowired SkillController sc = new SkillController(); Skill skill = new
		  Skill(1, "Spring Boot Test"); Skill skill2 = new Skill(2, "Java"); Skill
		  skill3 = new Skill(3, "SQL");
		  
		  @Before public void setupController() { sc.insertSkill(skill);
		  sc.insertSkill(skill2); }
		  
		  @Test public void testAllSkills() { sc.insertSkill(skill3);
		  assertTrue(sc.allSkills().contains(skill3)); }
		  
		  @Test public void testFindBySkill() { assertEquals(skill, sc.getBySkill(1));
		  }
		  
		  @Test public void testFindNonExistant() { assertNull(sc.getBySkill(0)); }
		  
		  @Test public void testGetAll() { List<Skill> skills = (List<Skill>)
		  sc.getSkills(); assertTrue(skills.contains(skill)); }
		  
		  @Test public void testGetOne() { assertEquals(skill,
		  sc.getSkills("Spring Boot Test")); } }
*/
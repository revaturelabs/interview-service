package com.revature.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.model.Skill;

@SpringBootTest(classes = {SkillService.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class SkillServiceTest {

	@Autowired
    private SkillService ss;
	
	@Test
	public void testAllSkill() {
		assertNotNull(ss.getAll());
	}
	
	@Test
	public void testInsertSkill() {
		Skill skill = new Skill(0, "testskill");
		assertTrue(ss.insertSkill(skill));
	
	}
	
	@Test
	public void testFindSkill() {
		assertNotNull(ss.findSkill("angular"));
	}
	
	
	
	
	
}

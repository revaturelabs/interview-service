package com.revature.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.model.Skill;

@SpringBootTest(classes = {SkillService.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class SkillServiceTest {

	@Autowired
    private SkillService ss;
	private Skill skill1 = new Skill(1, "angular");
	
	@Before
	public void setup() {
		ss.insertSkill(skill1);
	}
	
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
	public void testBadSkill() {
		assertFalse(ss.insertSkill(null));
	}
	
	@Test
	public void testFindSkill() {
		assertNotNull(ss.findSkill("angular"));
	}
}

package com.revature.service;


/**
 * @author Janel Williams 12/12/2019
 * Junit test for skill service methods, tests the methods in the service layer. 
 *  Passed in actual values for cleaner tests. 
 * Purposely didn't use assertnotnull because we wanted to make sure the appropriate values were
 * being returned. Assertnotnull will only give us a vague sense. 
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.Skill;

@SpringBootTest(classes = {SkillService.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class SkillServiceTest {
	


	@Autowired
	SkillService ss;
	Set<Job> testJob = new HashSet<>();
	Set<Profile> testProfile = new HashSet<>();
	
	Skill skill1 = new Skill(1, "angular", testProfile);
	Skill skill2 = new Skill(1, "angular", testProfile);
	Skill skill3 = new Skill(1, "angular", testProfile);


	@Before
	public void setup() {
		ss.insertSkill(skill1);
	}
	
	@Test
	public void testAllSkill() {
		List<Skill> list = new ArrayList<>();
			list.add(skill1);
			list.add(skill2);
			list.add(skill3);
		assertEquals(list.iterator().next().getId(),ss.getAll().iterator().next().getId());
	}
	
	@Test
	public void testInsertSkill() {
		assertTrue(ss.insertSkill(skill1));
	
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

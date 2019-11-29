package com.revature.controllers;

import static org.junit.Assert.assertTrue;

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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.model.Interview;
import com.revature.model.Profile;
import com.revature.model.Skill;

@SpringBootTest(classes = { ProfileController.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@ComponentScan("com.revature.service")
@EnableAutoConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class ProfileControllerTest {
	/**
	 * JUnit testing for the Skill Controller object
	 * @author John Thaddeus Kelly
	 */
	
	@Autowired
	ProfileController pc = new ProfileController();
	Profile profile1 = new Profile(1, "Bruce", "Banner", new HashSet<Skill>(), new HashSet<Interview>(), "description");
	Profile profile2 = new Profile(2, "Thor", "Odinson", new HashSet<Skill>(), new HashSet<Interview>(), "descrition");
	Profile profile3 = new Profile(3, "Jean", "Grey", new HashSet<Skill>(), new HashSet<Interview>(), "description");
	
	@Before
	public void setupDb() {
		pc.insertProfileInfo(profile1);
		pc.insertProfileInfo(profile2);
	}
	
	@Test
	public void testSetup() {
		pc.insertProfileInfo(profile3);
	}
	
	@Test
	public void testGetAll() {
		List<Profile> profiles = (List<Profile>) pc.getAll();
		assertTrue(profiles.contains(profile1));
	}
}

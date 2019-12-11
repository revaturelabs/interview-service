
package com.revature.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
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

import com.revature.controller.ProfileController;
import com.revature.model.Interview;
import com.revature.model.Profile;
import com.revature.model.Skill;

@SpringBootTest(classes = { ProfileController.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@ComponentScan("com.revature.service")
@EnableAutoConfiguration
// @EnableFeignClients(clients = { AuthInterface.class })
@TestPropertySource(locations = "classpath:application-test.properties")
public class ProfileControllerTest {
	/**
	 * JUnit testing for the Skill Controller object
	 * @author John Thaddeus Kelly
	 */
	
	@Autowired
	ProfileController pc = new ProfileController();

	Profile profile1 = new Profile(1, "Bruce", "Banner", "description");
	Profile profile2 = new Profile(2, "Thor", "Odinson", "descrition");
	Profile profile3 = new Profile(3, "Jean", "Grey",  "description");

	List<Profile> testProfile = new ArrayList<>();
	
	@Before
	public void setUp() {
		pc.insertProfileInfo(profile1);
		pc.insertProfileInfo(profile2);
		
	}
	
	@Test
	public void testSetup() {
		assertTrue(pc.insertProfileInfo(profile3));
	}
	
	@Test
	public void testGetAll() {
		// List<Profile> profiles = (List<Profile>) pc.getAll();
		List<Profile> testProfile = new ArrayList<>();
			testProfile.add(profile1);
			testProfile.add(profile2);
		assertEquals(testProfile.iterator().next().getId(), pc.getAll().iterator().next().getId());
	}
}

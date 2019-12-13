package com.revature.model;

/**
 * @author Janel Williams 12/12/2019
 * Junit test for Job model, tests entity relationships. 
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


// @SpringBootTest(classes = { Job.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @RunWith(SpringRunner.class)
// @EnableJpaRepositories("com.revature.repository")
// @EntityScan("com.revature.model")
// @ComponentScan("com.revature.service")
// @EnableAutoConfiguration
// // @EnableFeignClients(clients = { AuthInterface.class })
// @TestPropertySource(locations = "classpath:application-test.properties")
public class JobTest {

		Job testJob = new Job();
		Set<Profile> testProfiles = new HashSet();
		Set<Skill> testSkills = new HashSet();
		String description;
		String title;
		String title1;
		String title2;
		String lastname;
		String firstname;
	
		Profile profile1 = new Profile(0, firstname, lastname, description);
		Profile profile2 = new Profile(1, firstname, lastname, description);
		Profile profile3 = new Profile(2, firstname, lastname, description);

		Skill skill1 = new Skill(0, title, testProfiles);
		Skill skill2 = new Skill(1, title1, testProfiles);
		Skill skill3 = new Skill(2, title2, testProfiles);
	


		@Before
		public void setUp(){
		String description = "description";
		String title = "title";
		String title1 = "title1";
		String title2 = "title2";

		String lastname = "lastname";
		String firstname = "firstname";
			
			Set<Profile> testProfiles = new HashSet<>();
			testProfiles.add(profile1);
			testProfiles.add(profile2);
			testProfiles.add(profile3);

	

	
			Set<Skill> testSkills = new HashSet<>();
			testSkills.add(skill1);
			testSkills.add(skill2);
			testSkills.add(skill3);

			Job testJob = new Job(0, title, description, testSkills, false);
	
		}
	

	
	@Test
	public void testId() {
		assertEquals(0, testJob.getId());
	}
	
	@Test
	public void testTitle(){
		assertEquals(title, testJob.getTitle());
	}
	
	@Test
	public void testDescription() {
		assertEquals(description, testJob.getDescription());
	}
	
	@Test
	public void testSkills() {
	
		assertEquals(testSkills, testJob.getSkills());
	}
	
	@Test
	public void testFilled() {
		assertEquals(false, testJob.isFilled());
	}
	
	// @Test
	// public void testProfiles() {
	
	// 	assertEquals(testProfiles, testJob.getProfiles());
	// }
	
	@Test
	public void testHashCode() {
		assertNotNull(testJob.hashCode());
	}
	
	@Test
	public void testToString() {
		assertNotNull(testJob.toString());
	}
}

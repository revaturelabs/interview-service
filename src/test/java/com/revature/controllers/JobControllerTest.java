
package com.revature.controllers;
/**
 * @author Janel Williams 12/12/2019
 * Junit test Job controller methods. 
 * Passed in actual values for cleaner tests. 
 * Purposely didn't use assertnotnull because we wanted to make sure the appropriate values were
 * being returned. Assertnotnull will only give us a vague sense. 
 */

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
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
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.controller.JobController;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.Skill;

// Configuring spring context
@SpringBootTest(classes = { JobController.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@ComponentScan("com.revature.service")
@EnableAutoConfiguration
// @EnableFeignClients(clients = { AuthInterface.class })
@TestPropertySource(locations = "classpath:application-test.properties")
public class JobControllerTest {


	@Autowired
	JobController jc;

	//Initializing values to be passed into tests. 
	String skilltitle;

	Set<Profile> testProfiles = new HashSet(); 
	Set<Skill> testSkills = new HashSet();
	List<Job> list = new ArrayList();
	Profile profile1 = new Profile(0, "firstname", "lastname", "description");
	Profile profile2 = new Profile(1, "firstname", "lastname", "description");
	Profile profile3 = new Profile(2, "firstname", "lastname", "description");

	Skill skill1 = new Skill(0, skilltitle, testProfiles);
	Skill skill2 = new Skill(1, skilltitle, testProfiles);
	Skill skill3 = new Skill(2, skilltitle, testProfiles);

	Job job1 = new Job(1, "Avenger", "Saving the World", testSkills, true);
	Job job2 = new Job(2, "Justice League", "Rescuing the World", testSkills, true);
	Job job3 = new Job(3, "Villain", "Destroying the World", testSkills, true);
	
	//Setting up the controller, passing in Job values using the initialized classes above 
	@Before
	public void setup() {
		jc.insertJobInfo(job1);
		jc.insertJobInfo(job2);
		jc.insertJobInfo(job3);

	

	}
	//Testing the setup 
	@Test
	public void testSetup() {
		//implicitly tests insertJobInfo method 
		assertTrue(jc.insertJobInfo(job3));
	}
	
	//Tests get all method 
	@Test
	public void testGetAll() {
		
		List<Job> list = new ArrayList<Job>();
		list.add(job1);
		list.add(job2);
		list.add(job3);

		//can not compare non primitive values, so we iterate and get the id of the final node in the list
		assertEquals(list.iterator().next().getId(), jc.getAll().iterator().next().getId());
	}
	
	//Tests get title 
	@Test
	public void testGetTitle() {
		assertEquals(job1.getId(), jc.getByTitle("Avenger").getId());
	}
	
	//Tests update job method 
	@Test
	public void testUpdate() {
		assertTrue(jc.updateJobInfo(new Job(1, "Avenger", "Defending the World", testSkills, true)));
	}

	
}

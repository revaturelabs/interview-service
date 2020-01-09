
package com.revature.controllers;

import static org.junit.Assert.assertEquals;
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
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.controller.JobController;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.Skill;

@SpringBootTest(classes = { JobController.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@ComponentScan("com.revature.service")
@EnableAutoConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class JobControllerTest {
	/**
	 * JUnit tests for the Job Controller object
	 * 
	 * @author John Thaddeus Kelly
	 */

	@Autowired
	JobController jc;

	String skilltitle;

	Set<Profile> testProfiles = new HashSet<Profile>();
	Set<Skill> testSkills = new HashSet<Skill>();
	List<Job> list = new ArrayList<Job>();
	Profile profile1 = new Profile(0, "firstname", "lastname", "description");
	Profile profile2 = new Profile(1, "firstname", "lastname", "description");
	Profile profile3 = new Profile(2, "firstname", "lastname", "description");

	Skill skill1 = new Skill(0, skilltitle, testProfiles);
	Skill skill2 = new Skill(1, skilltitle, testProfiles);
	Skill skill3 = new Skill(2, skilltitle, testProfiles);

	Job job1 = new Job(1, "Avenger", "Saving the World", testSkills, true);
	Job job2 = new Job(2, "Justice League", "Rescuing the World", testSkills, true);
	Job job3 = new Job(3, "Villain", "Destroying the World", testSkills, true);

	@Before
	public void setup() {
		jc.insertJobInfo(job1);
		jc.insertJobInfo(job2);
		jc.insertJobInfo(job3);

	}

	@Test
	public void testSetup() {
		// implicitly tests insertJobInfo
		assertTrue(jc.insertJobInfo(job3));
	}

	@Test
	public void testGetAll() {

		List<Job> list = new ArrayList<Job>();
		list.add(job1);
		list.add(job2);
		list.add(job3);

		// can not compare non primitive values
		assertEquals(list.iterator().next().getId(), jc.getAll().iterator().next().getId());
	}

	@Test
	public void testGetTitle() {
		assertEquals(job1.getId(), jc.getByTitle("Avenger").getId());
	}

	@Test
	public void testUpdate() {
		assertTrue(jc.updateJobInfo(new Job(1, "Avenger", "Defending the World", testSkills, true)));
	}

}

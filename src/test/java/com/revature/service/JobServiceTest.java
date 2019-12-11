package com.revature.service;

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
import com.revature.repository.JobRepository;

@SpringBootTest(classes = {JobService.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class JobServiceTest {
	
	/**
	 * Unit tests for the Job Service object
	 * @author John Thaddeus Kelly
	 */

	@Autowired 
	JobRepository jr; 

	@Autowired
	JobService js = new JobService(jr);
	
	String skilltitle;
	String description;
	String description2;
	String jobtitle;
	String jobtitle2;
	
	Job testJob = new Job();
	Job testJob2 = new Job();
	Set<Profile> testProfiles = new HashSet();
	Set<Skill> testSkills = new HashSet();

	Profile profile1 = new Profile(0, "firstname", "lastname", "description");
	Profile profile2 = new Profile(1, "firstname", "lastname", "description");
	Profile profile3 = new Profile(2, "firstname", "lastname", "description");

	Skill skill1 = new Skill(0, skilltitle, testProfiles);
	Skill skill2 = new Skill(1, skilltitle, testProfiles);
	Skill skill3 = new Skill(2, skilltitle, testProfiles);



	
	@Before
	public void setup() {
	String jobtitle = "skill title";
	String title2 = "job title";
	String description = "description";
	String description2 = "another description";

	Set<Profile> testProfiles = new HashSet<>();
		testProfiles.add(profile1);
		testProfiles.add(profile2);
		testProfiles.add(profile3);




	Set<Skill> testSkills = new HashSet<>();
		testSkills.add(skill1);
		testSkills.add(skill2);
		testSkills.add(skill3);


	Job testJob = new Job(0, jobtitle, description, testSkills, true);
	Job testJob2 = new Job(2,jobtitle2, description2, testSkills, true);
	js.insertJobInfo(testJob);
	js.insertJobInfo(testJob2);
	}
	
	@Test
	public void testInsertJob() {

		assertTrue(js.insertJobInfo(testJob));
	}
	
	@Test
	public void testBadInsertJob() {
		assertFalse(js.insertJobInfo(null));
	}
	
	@Test
	public void testUpdateJob() {
		assertTrue(js.updateJobInfo(testJob));
	}
	@Test
	public void testBadJob() {
		assertFalse(js.updateJobInfo(null));
	}
	@Test
	public void testAllJobs() {
		List<Job> list = new ArrayList();
		list.add(testJob);
		assertEquals(list, js.getAllJobs());
	}
	
	@Test
	public void testFindAll() {
		assertNotNull(js.findAll());
	}
	
	@Test
	public void testGetTitle() {
		assertEquals(testJob, js.findByTitle(jobtitle));
	}
	
	@Test
	public void testGetId() {
		assertEquals(testJob2, js.findById(2));
	}
}

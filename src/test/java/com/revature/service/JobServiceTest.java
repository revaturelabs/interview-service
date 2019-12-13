package com.revature.service;

/**
 * @author Janel Williams 12/12/2019
 * Junit test for Job service methods, tests service layer methods for job service. 
 * Passed in actual values for cleaner tests. 
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
import com.revature.repository.JobRepository;

@SpringBootTest(classes = {JobService.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class JobServiceTest {
	


	@Autowired 
	JobRepository jr; 

	@Autowired
	JobService js = new JobService(jr);
	
	String skilltitle;
	String description;
	String description2;
	String description3;  
	String jobtitle;
	String jobtitle2;
	String jobtitle3;
	
	Job testJob = new Job();
	Job testJob2 = new Job();
	Job testJob3 = new Job();
	Set<Profile> testProfiles = new HashSet();
	Set<Skill> testSkills = new HashSet();

	Profile profile1 = new Profile(0, "firstname", "lastname", "description");
	Profile profile2 = new Profile(1, "firstname", "lastname", "description");
	Profile profile3 = new Profile(2, "firstname", "lastname", "description");

	Skill skill1 = new Skill(0, skilltitle, testProfiles);
	Skill skill2 = new Skill(1, skilltitle, testProfiles);
	Skill skill3 = new Skill(2, skilltitle, testProfiles);



	//Sets up the objects that will be used in the tests 
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
	Job testJob3 = new Job(3, jobtitle3, description3, testSkills, true);
	
	js.insertJobInfo(testJob);
	js.insertJobInfo(testJob2);
	}
	
	//Tests set up and insertJobInfo method 
	@Test
	public void testInsertJob() {

		assertTrue(js.insertJobInfo(testJob));
	}
	

	//Tests update job 
	@Test
	public void testUpdateJob() {
		assertTrue(js.updateJobInfo(testJob3));
	}
	
	//Tests get all jobs method 
	@Test
	public void testAllJobs() {
		List<Job> list = new ArrayList();
		list.add(testJob);
		list.add(testJob2);
		//Can't compare objects in assertEquals so we iterated through a list 
		assertEquals(list.iterator().next().getId(), js.getAllJobs().iterator().next().getId());
	}
	
	@Test
	public void testFindAll() {
		assertNotNull(js.findAll());
	}


	//
	@Test
	public void testGetTitle() {
		assertEquals(testJob.getId(), js.findByTitle(jobtitle).getId());
	}
	
	@Test
	public void testGetId() {
		assertEquals(testJob2.getId(), js.findById(2).getId());
	}
}

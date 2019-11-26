package com.revature.service;

import static org.junit.Assert.*; 

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.Skill;

@SpringBootTest(classes = {JobService.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class JobServiceTest {
	
	/*
	 * Unit tests for the Job Service object
	 * @author John Thaddeus Kelly
	 */

	@Autowired
    private JobService js;
	
	@Test
	public void testInsertJob() {
		List<Skill> skills = new ArrayList<>();
		skills.add(new Skill());
		List<Profile> profiles = new ArrayList<>();
		profiles.add(new Profile());
		Job job = new Job(0, "test", "description", skills, true, profiles);
		assertTrue(js.insertJobInfo(job));
	}
	
	@Test
	public void testBadInsertJob() {
		assertFalse(js.insertJobInfo(null));
	}
	
	@Test
	public void testUpdateJob() {
		Job job = new Job();
		assertTrue(js.updateJobInfo(job));
		}
	@Test
	public void testAllJobs() {
		assertNotNull(js.getAllJobs());
	}
	
	@Test
	public void testFindAll() {
		assertNotNull(js.findAll());
	}
	
	@Test
	public void testGetTitle() {
		assertNotNull(js.findByTitle("Code Wrangler"));
	}
}

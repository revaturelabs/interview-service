package com.revature.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

	/*
	 * Unit tests for the Job object
	 * @author John Thaddeus Kelly
	 */

public class JobTest {
	Job testJob = new Job();

	@Test
	public void testExistance() {
		List<Skill> skills = new ArrayList<>();
		skills.add(new Skill());
		List<Profile> profiles = new ArrayList<>();
		profiles.add(new Profile());
		Job job = new Job(0, "title", "description", skills, true, profiles) ;
		assertNotNull(job);
	}
	
	@Test
	public void testExistenceArgs() {
		assertNotNull(testJob);
	}

	@Test
	public void testId() {
		testJob.setId(0);
		assertEquals(0, testJob.getId());
	}
	
	@Test
	public void testTitle(){
		testJob.setTitle("title");
		assertEquals("title", testJob.getTitle());
	}
	
	@Test
	public void testDescription() {
		testJob.setDescription("description");
		assertEquals("description", testJob.getDescription());
	}
	
	@Test
	public void testSkills() {
		List<Skill> skills = new ArrayList<>();
		skills.add(new Skill());
		testJob.setSkills(skills);
		assertNotNull(testJob.getSkills().get(0));
	}
	
	@Test
	public void testFilled() {
		testJob.setFilled(true);
		assertTrue(testJob.isFilled());
	}
	
	@Test
	public void testProfiles() {
		List<Profile> profiles = new ArrayList<>();
		profiles.add(new Profile());
		testJob.setProfiles(profiles);
		assertNotNull(testJob.getProfiles().get(0));
	}
	
	@Test
	public void testHashCode() {
		assertNotNull(testJob.hashCode());
	}
	
	@Test
	public void testToString() {
		assertNotNull(testJob.toString());
	}
}

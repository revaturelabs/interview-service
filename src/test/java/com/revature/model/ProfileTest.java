package com.revature.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

	/**
	 * Unit tests for the Profile object
	 * @author John Thaddeus Kelly
	 */

public class ProfileTest {
	Profile testProfile = new Profile();
	
	@Test
	public void testId() {
		testProfile.setId(0);
		assertEquals(0, testProfile.getId());
	}
	
	@Test
	public void testFirstName() {
		testProfile.setFirstName("first");
		assertEquals("first", testProfile.getFirstName());
	}
	
	@Test
	public void testLastName() {
		testProfile.setLastName("last");
		assertEquals("last", testProfile.getLastName());
	}
	
	@Test
	public void testDescription() {
		testProfile.setDescription("description");
		assertEquals("description", testProfile.getDescription());
	}
	
	@Test
	public void testSkills() {
		Set<Skill> skills = new HashSet<>();
		skills.add(new Skill());
		testProfile.setSkills(skills);
		assertEquals(skills, testProfile.getSkills());
	}
	
	@Test
	public void testInterviews() {
		Set<Interview> interviews = new HashSet<>();
		interviews.add(new Interview());
		testProfile.setInterviews(interviews);
		assertEquals(interviews, testProfile.getInterviews());
	}
	
	@Test
	public void testHashcode() {
		assertNotNull(testProfile.hashCode());
	}
	
	@Test
	public void testToString() {
		assertNotNull(testProfile.toString());
	}
}

package com.revature.model;
/**
 * @author Janel Williams 12/12/2019
 * Junit test for profile model, tests entity relationships. 
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.Before;



public class ProfileTest {
	Profile testProfile = new Profile();
	String firstname;
	String lastname;
	String description;


	

	@Before
	public void setUp(){
		String firstname = "firstname";
		String lastname = "lastname";
		String description = "description";
		Profile testProfile = new Profile(0,firstname, lastname, description);

	}
	@Test
	public void testId() {
		assertEquals(0, testProfile.getId());
	}
	
	@Test
	public void testFirstName() {
		assertEquals(firstname, testProfile.getFirstName());
	}
	
	@Test
	public void testLastName() {
		assertEquals(lastname, testProfile.getLastName());
	}
	
	@Test
	public void testDescription() {
		assertEquals(description, testProfile.getDescription());
	}
	
	// @Test
	// public void testSkills() {
	// 	Set<Skill> skills = new HashSet<>();
	// 	skills.add(new Skill());
	// 	testProfile.setSkills(skills);
	// 	assertEquals(skills, testProfile.getSkills());
	// }
	
	// @Test
	// public void testInterviews() {
	// 	Set<Interview> interviews = new HashSet<>();
	// 	interviews.add(new Interview());
	// 	testProfile.setInterviews(interviews);
	// 	assertEquals(interviews, testProfile.getInterviews());
	// }
	
	@Test
	public void testHashcode() {
		assertNotNull(testProfile.hashCode());
	}
	
	@Test
	public void testToString() {
		assertNotNull(testProfile.toString());
	}
}

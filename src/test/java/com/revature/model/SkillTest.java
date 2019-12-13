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



public class SkillTest {
	Skill testSkill = new Skill();
	Set<Profile> testProfiles = new HashSet<>();
	
	String title;
	Profile profile1 = new Profile(0, "firstname", "lastname", "description");
	Profile profile2 = new Profile(1, "firstname", "lastname", "description");
	Profile profile3 = new Profile(2, "firstname", "lastname", "description");
	
	@Before
	public void setUp(){
	String title = "title";

	Set<Profile> testProfiles = new HashSet<>();
	testProfiles.add(profile1);
	testProfiles.add(profile2);
	testProfiles.add(profile3);
	
	Skill testSkill = new Skill(0, title, testProfiles);

	}
	@Test
	public void testId() {
		assertEquals(0, testSkill.getId());
	}
	
	@Test
	public void testTitle() {
		
		assertEquals(title, testSkill.getTitle());
		
	}
	
	@Test
	public void testHashcode() {
		assertNotNull(testSkill.hashCode());
	}
	
	@Test
	public void testToString() {
		assertNotNull(testSkill.toString());
	}
}

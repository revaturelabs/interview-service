package com.revature.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Unit tests for the Skill object
 * @author John Thaddeus Kelly
 */

public class SkillTest {
	Skill skill = new Skill();
	
	@Test
	public void testId() {
		skill.setId(1);
		assertEquals(1, skill.getId());
	}
	
	@Test
	public void testTitle() {
		skill.setTitle("skill");
		assertEquals("skill", skill.getTitle());
	}
	
	@Test
	public void testHashcode() {
		assertNotNull(skill.hashCode());
	}
	
	@Test
	public void testToString() {
		assertNotNull(skill.toString());
	}
}

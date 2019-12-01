package com.revature.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
	/*
	 * Unit testing for the Interview object
	 * @author John Thaddeus Kelly
	 */
public class InterviewTest {
	Interview testInterview = new Interview();
	
	@Test
	public void testExistance() {
		Profile profile = new Profile();
		List<Comment> c = new ArrayList<>();
		Job job = new Job();
		Set<User> users = new HashSet<>();
		users.add(new User());
		Interview interview = new Interview(0, profile, c, Timestamp.from(Instant.now()), true, job, users);
		assertNotNull(interview);
	}
	
	@Test
	public void testExistanceArgs() {
		assertNotNull(testInterview);
	}
	
	@Test
	public void testId() {
		testInterview.setId(0);
		assertEquals(0, testInterview.getId());
	}
	
	@Test
	public void testProfile() {
		Profile profile = new Profile();
		testInterview.setProfile(profile);
		assertEquals(profile, testInterview.getProfile());
	}
	
	//[TODO] Completely re-write. New comment model was made.
	@Test
	public void testComments(){
		fail("A new comment model was made. Please re-write");
		//testInterview.setComments("comments");
		//assertEquals("comments", testInterview.getComments());
	}
	
	@Test
	public void testDate(){
		Timestamp date = Timestamp.from(Instant.now());
		testInterview.setDate(date);
		assertEquals(date, testInterview.getDate());
	}
	
	@Test
	public void testComplete() {
		testInterview.setComplete(true);
		assertTrue(testInterview.isComplete());
	}
	
	@Test
	public void testJob() {
		Job job = new Job();
		testInterview.setJob(job);
		assertEquals(job, testInterview.getJob());
	}
	
	@Test
	public void testUsers() {
		Set<User> users = new HashSet<>();
		users.add(new User());
		testInterview.setUsers(users);
		assertEquals(users, testInterview.getUsers());
	}
	
	@Test
	public void testHashcode() {
		assertNotNull(testInterview.hashCode());
	}
	
	@Test
	public void testToString() {
		assertNotNull(testInterview.toString());
	}
}

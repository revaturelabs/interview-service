package com.revature.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
	/*
	 * Unit testing for the Interview object
	 * @author John Thaddeus Kelly
	 */
public class InterviewTest {
	Interview testInterview = new Interview();
	List<Comment> testComment = new ArrayList();
	Set<User> testUser = new HashSet();
	Timestamp date;
	Job testJob;
	Profile profile1;
	Set<Profile> testProfiles = new HashSet();
	Set<Skill> testSkills = new HashSet();
	Set<Interview> testInterviewSet = new HashSet();



	Skill skill1 = new Skill(0,"title", testProfiles);
	Skill skill2 = new Skill(1, "title", testProfiles);
	Skill skill3 = new Skill(2, "title", testProfiles);

	Comment comment1 = new Comment(0, date, "name", "text", testInterview);
	Comment comment2 = new Comment(0, date, "name", "text", testInterview);
	Comment comment3 = new Comment(0, date, "name", "text", testInterview);


	User user1 = new User(0, "username", "password", testInterviewSet);
	User user2 = new User(1, "username", "password", testInterviewSet);
	User user3 = new User(2, "username", "password", testInterviewSet);




	@Before
	public void setUp(){
		Profile profile1 = new Profile(0, "firstname", "lastname", "description");
		// Profile profile2 = new Profile(1, "firstname", "lastname", "description");
		// Profile profile3 = new Profile(2, "firstname", "lastname", "description");
	
		// Set<Profile> testProfiles = new HashSet<>();
		// 	testProfiles.add(profile1);
		// 	testProfiles.add(profile2);
		// 	testProfiles.add(profile3);


		Set<Skill> testSkills = new HashSet<>();
			testSkills.add(skill1);
			testSkills.add(skill2);
			testSkills.add(skill3);

		List<Comment> testComment = new ArrayList();
			testComment.add(comment1);
			testComment.add(comment2);
			testComment.add(comment3);

		Set<User> testUser = new HashSet();
			testUser.add(user1);
			testUser.add(user2);
			testUser.add(user3);

		

		Job testJob = new Job(0, "title", "description", testSkills, true);
		Interview testInterview = new Interview(0, profile1, date, true, testJob, testUser);

	}




	
	@Test
	public void testId() {
		assertEquals(0, testInterview.getId());
	}
	
	@Test
	public void testProfile() {
		
		assertEquals(profile1, testInterview.getProfile());
		
	}
	
	
	@Test
	public void testDate(){
		assertEquals(date, testInterview.getDate());
	}
	
	@Test
	public void testComplete() {
		
		assertEquals(false, testInterview.getIsComplete());
	}
	
	@Test
	public void testJob() {
		
			assertEquals(testJob, testInterview.getJob());
		
		
	}
	
	@Test
	public void testUsers() {
	
		assertEquals(testUser, testInterview.getUsers());
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

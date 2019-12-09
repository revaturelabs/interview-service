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
	List<Job> testJob = new ArrayList();
	Timestamp date;
	Set<Profile> testProfiles = new HashSet();
	Set<Skill> testSkills = new HashSet();


	Profile profile1 = new Profile(0, "firstname", "lastname", "description");
	Profile profile2 = new Profile(1, "firstname", "lastname", "description");
	Profile profile3 = new Profile(2, "firstname", "lastname", "description");

	Skill skill1 = new Skill("title", testProfiles);
	Skill skill2 = new Skill("title", testProfiles);
	Skill skill3 = new Skill("title", testProfiles);

	Comment comment1 = new Comment(0, date, "name", "text", testInterview);
	Comment comment2 = new Comment(0, date, "name", "text", testInterview);
	Comment comment3 = new Comment(0, date, "name", "text", testInterview);

	Job job1 = new Job(0, "title", "description", testSkills, false, testProfiles);
	Job job2 = new Job(0, "title", "description", testSkills, false, testProfiles);
	Job job3 = new Job(0, "title", "description", testSkills, false, testProfiles);

	User user1 = new User(0, "username", "password");
	User user2 = new User(0, "username", "password");
	User user3 = new User(0, "username", "password");




	@Before
	public void setUp(){
		Set<Profile> testProfiles = new HashSet<>();
			testProfiles.add(profile1);
			testProfiles.add(profile2);
			testProfiles.add(profile3);


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

		List<Job> testJob= new ArrayList();
			testJob.add(job1);
			testJob.add(job2);
			testJob.add(job3);


		Interview testInterview = new Interview(0, profile1, date, true, job1,testUser);

	}




	
	@Test
	public void testId() {
		assertEquals(0, testInterview.getId());
	}
	
	@Test
	public void testProfile() {
		
		while (testProfiles.iterator().hasNext()){
			assertEquals(profile3, testInterview.getProfile());
		}
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
		while (testJob.iterator().hasNext()){
			assertEquals(testJob, testInterview.getProfile());
		
		}
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

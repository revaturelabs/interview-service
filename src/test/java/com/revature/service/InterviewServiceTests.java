package com.revature.service;


/**
 * @author Janel Williams 12/12/2019
 * Junit test for Interview service methods, tests layer methods. 
 * There was some trouble with the custom repository here. 
 * 
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.model.Interview;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.Skill;
import com.revature.model.User;

//Configuring the spring context 
@SpringBootTest(classes = {InterviewService.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class InterviewServiceTests {


	
	@Autowired
	private InterviewService is;

	Set<Skill> skillset = new HashSet<>();
	Set<Profile> profileset = new HashSet<>();
	Set<Interview> interviewset = new HashSet<>();
	Set<User> userset = new HashSet<>();

	Timestamp date;


	Profile profile1 = new Profile(1, "Fred", "Jenkins", "description");
	Profile profile2 = new Profile(2, "testfirst", "testlast", "description");
	Profile profile3 = new Profile(3, "anotherone", "anotherone", "description");

	Job job1 = new Job(1, "title1", "description", skillset, true);
	Job job2 = new Job(2, "title1", "description", skillset, true);
	Job job3 = new Job(3, "title1", "description", skillset, true);


	Interview interview1 = new Interview(1, profile1, Timestamp.from(Instant.now()), true,
	job1, userset);
	Interview interview2 = new Interview(2, profile2, Timestamp.from(Instant.now()), true,
	job2, userset);
	Interview interview3 = new Interview(3, profile3, date, true,
	job3, userset);

	Interview interview = new Interview();

	//Setting up the interview objects 
	@Before
	public void setUp(){

	is.insertInterviewInfo(interview1);
	is.insertInterviewInfo(interview2);

	}
	
	//Testing the setup/ insertInterviewInfo method 
	@Test
	public void testSaveInterview() {
		assertTrue(is.insertInterviewInfo(interview3));
	}
	

	//Testing get all methods 
	@Test
	public void testGetAll() {
		List<Interview> listInterview = new ArrayList<>();
			listInterview.add(interview1);
			listInterview.add(interview2);

			//Cannot compare objects in an assert Equals, so we used iterators to grab the last item and compare by id. 
			assertEquals(listInterview.iterator().next().getId(), is.getAllInterviews().iterator().next().getId());
	}
	
}

package com.revature.service;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.model.Interview;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.Skill;
import com.revature.repository.InterviewRepository;
import com.revature.repository.JobRepository;
import com.revature.repository.ProfileRepository;

import junit.framework.Assert;

/*@SpringBootTest(classes = {InterviewService.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")*/
public class InterviewServiceTests {
	
	/**
	 * Unit tests for the Interview Service object
	 * @author John Thaddeus Kelly
	 * @author GratefulHeart (Banjo, O. D.)
	 */

	// Setup profile
	private static Profile profile1 = new Profile(1, "fName1", "lName1", "location1", "email1", "description1");
	private static Profile profile2 = new Profile(2, "fname2", "lName2", "location2", "email2", "description2");
	private static Profile profile3 = new Profile(3, "fName3", "lName3", "location3", "email3", "description3");

	// Setup job
	private static Job job1 = new Job(1, "title1", "description1", "location1", new HashSet<Skill>(), true);
	private static Job job2 = new Job(2, "title2", "description2", "location2", new HashSet<Skill>(), true);
	private static Job job3 = new Job(3, "title3", "description3", "location3", new HashSet<Skill>(), true);

	// Setup Interviews
	private static Interview interview1 = new Interview(1, profile1, Calendar.getInstance(), true, job1);
	private static Interview interview2 = new Interview(2, profile2, Calendar.getInstance(), true, job2);
	private static Interview interview3 = new Interview(3, profile3, Calendar.getInstance(), true, job3);

	private InterviewRepository interviewRepository = Mockito.mock(InterviewRepository.class);
	private JobRepository jobRepository = Mockito.mock(JobRepository.class);
	private ProfileRepository profileRepository = Mockito.mock(ProfileRepository.class);
	private InterviewService is;
	

	@Before
	public void setUp() throws Exception {
		is = new InterviewService(interviewRepository, jobRepository,profileRepository);
		System.out.println(is);
	}
	
	
	  @Test public void testInsertInterviewInfo() {
		  Mockito.when(jobRepository.findById(1)).thenReturn(job1);
		  Mockito.when(profileRepository.findById(1)).thenReturn(profile1);
		  assertEquals(true, is.insertInterviewInfo(interview1));
		  Mockito.verify(interviewRepository).save(interview1);
	  }
	  
	  @Test public void testInsertInterviewInfoError() {
		  Mockito.when(jobRepository.findById(1)).thenReturn(job1);
		  Mockito.when(profileRepository.findById(1)).thenReturn(profile1);
		  Mockito.when(interviewRepository.save(interview1)).thenThrow(new RuntimeException());
		  assertEquals(false, is.insertInterviewInfo(interview1));
	  }
	  

	@Test
	public void testGetAllInterview() {
		List<Interview> interviews = new ArrayList<>();
		interviews.add(interview1);
		interviews.add(interview2);
		interviews.add(interview3);
		Mockito.when(interviewRepository.findAll()).thenReturn(interviews);
		assertEquals(interviews, is.getAllInterviews());
		Mockito.verify(interviewRepository).findAll();
	}
	 
	
	@Test
	public void testGetById() {
		
		Mockito.when(interviewRepository.findById(1)).thenReturn(interview1);
		assertEquals(interview1, is.getById(1));
		Mockito.verify(interviewRepository).findById(1);
	}
	
}

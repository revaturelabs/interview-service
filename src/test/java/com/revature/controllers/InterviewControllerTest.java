package com.revature.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.controller.InterviewController;
import com.revature.model.Interview;
import com.revature.model.InterviewInterviewer;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.Skill;
import com.revature.service.InterviewInterviewerService;
import com.revature.service.InterviewService;

/**
 * Below annotations (above the class) is useful for integration-testing
 * @author ryank
 */
//@SpringBootTest(classes = { InterviewController.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class)
//@EnableJpaRepositories("com.revature.repository")
//@EntityScan("com.revature.model")
//@ComponentScan("com.revature.service")
//@EnableAutoConfiguration
//@TestPropertySource(locations = "classpath:application-test.properties")

public class InterviewControllerTest {
	
	//Setup profile
	private static Profile profile1 = new Profile(1, "fName1", "lName1", "location1", "email1", "description1");
	private static Profile profile2 = new Profile(2, "fname2", "lName2", "location2", "email2", "description2");
	private static Profile profile3 = new Profile(3, "fName3", "lName3", "location3", "email3", "description3");
	
	//Setup job
	private static Job job1 = new Job(1, "title1", "description1", "location1", new HashSet<Skill>(), true);
	private static Job job2 = new Job(2, "title2", "description2", "location2", new HashSet<Skill>(), true);
	private static Job job3 = new Job(3, "title3", "description3", "location3", new HashSet<Skill>(), true);
	
	//Setup Interviews
	private static Interview interview1 = new Interview(1, profile1, Calendar.getInstance(), true, job1);
	private static Interview interview2 = new Interview(2, profile2, Calendar.getInstance(), true, job2);
	private static Interview interview3 = new Interview(3, profile3, Calendar.getInstance(), true, job3);
	
	//Setup InterviewInterviewer
	private static InterviewInterviewer ii1 = new InterviewInterviewer(1, "Great interview", interview1,  "Bob");
	
	private InterviewService is = Mockito.mock(InterviewService.class);
	private InterviewInterviewerService iis = Mockito.mock(InterviewInterviewerService.class);

	private InterviewController ic;
	
	
	public InterviewControllerTest() {
	}
	
//	@Autowired
//	public InterviewControllerTest(InterviewController ic) {
//		this.ic = ic;
//	}
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting up to test expected InterviewController behavior");
		
		ic = new InterviewController(is, iis);

	}
	
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testSaveInterview() {
		Mockito.when(is.insertInterviewInfo(interview1)).thenReturn(true);
		Mockito.when(is.insertInterviewInfo(interview2)).thenReturn(true);
		Mockito.when(is.insertInterviewInfo(interview3)).thenReturn(true);
		
		assertEquals(true, ic.saveInterview(interview1));
		assertEquals(true, ic.saveInterview(interview2));
		assertEquals(true, ic.saveInterview(interview3));

		Mockito.verify(is).insertInterviewInfo(interview1);
		Mockito.verify(is).insertInterviewInfo(interview2);
		Mockito.verify(is).insertInterviewInfo(interview3);

	}

	@Test
	public void testGetAll() {

		List<Interview> allInterviews = new ArrayList<>();
		allInterviews.add(interview1);
		allInterviews.add(interview2);
		allInterviews.add(interview3);
		
		Mockito.when(is.getAllInterviews()).thenReturn(allInterviews);
		
		//assertEquals(allInterviews.iterator().next(), ic.getAll().iterator().next());
		assertEquals(allInterviews, ic.getAll());
		
		Mockito.verify(is).getAllInterviews();
	}

	@Test
	public void getById() {
		Mockito.when(is.getById(1)).thenReturn(interview1);
		
		//assertEquals(ic.getById(1).getId(), interview1.getId());
		assertEquals(interview1, ic.getById(1));
		
		Mockito.verify(is).getById(1);
	}
	
//	@Test
//	public void findByInterview() {
//		Mockito.when(methodCall)
//		
//		List<InterviewInterviewer> list = new ArrayList<>();
//		list.add(ii1);
//		
//		
//		
//	}
//			
//	@PostMapping("/interviews")
//	public List<InterviewInterviewer> findByInterview(@RequestBody Interview interview){
//		return nterviewInterviewerService.findByInterview(interview);
//	}
}

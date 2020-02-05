package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.revature.model.Comment;
import com.revature.model.Interview;
import com.revature.model.InterviewInterviewer;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.Skill;
import com.revature.repository.CommentRepository;

public class CommentServiceTest {

	//Mockito starter stuff.
	@Rule
	public MockitoRule mockRule = MockitoJUnit.rule();
	
	@Mock
	CommentRepository commRep;
	
	@InjectMocks
	CommentService commServ;

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
	}
	
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
	
	//set up interviewInterviewer 
	private static InterviewInterviewer interviewInterviewer1 = new InterviewInterviewer(1, "good interview", interview1, "quinn");
	private static InterviewInterviewer interviewInterviewer2 = new InterviewInterviewer(2, "bad interview", interview2, "matt");
	private static InterviewInterviewer interviewInterviewer3 = new InterviewInterviewer(3, "great interview", interview3, "andrew");
	
//////////////////////////////////////////////////////////////	
	
	@Test
	public void testFindAll() {
		System.out.println("in findAll");
		
		GregorianCalendar myDate = new GregorianCalendar(2008, 5, 11);
		GregorianCalendar hotDate = new GregorianCalendar(2002, 1, 12);
		GregorianCalendar coldDate = new GregorianCalendar(2011, 11, 10);
		
		List<Comment> commentList = new ArrayList<Comment>();

		Comment commA = Mockito.mock(Comment.class);
		commA.setId(1);
		commA.setDate(myDate);
		commA.setText("Holy cow, what a great interview!");
		commA.setInterviewInterviewer(interviewInterviewer1);
		commentList.add(commA);

		Comment commB = Mockito.mock(Comment.class);
		commB.setId(2);
		commB.setDate(hotDate);
		commB.setText("Hmm.");
		commB.setInterviewInterviewer(interviewInterviewer2);
		commentList.add(commB);
		
		Comment commC = Mockito.mock(Comment.class);
		commC.setId(3);
		commC.setDate(coldDate);
		commC.setInterviewInterviewer(interviewInterviewer3);
		commentList.add(commC);
		
		when(commRep.findAll()).thenReturn(commentList);
		
		Iterable<Comment> reqList = commServ.findAll();
		
		assertEquals(reqList, commentList);
		verify(commRep, times(1)).findAll();
	}
	
	
}

package com.revature.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.controller.CommentController;
import com.revature.model.Comment;
import com.revature.model.Interview;
import com.revature.model.InterviewInterviewer;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.Skill;
import com.revature.service.CommentService;

/** A class to test the methods of the CommentController class. These methods are insertComment, 
 findInterviewById and findAll.  
 @author Miranda Brawner */
public class CommentControllerTest {

	private CommentController ctrl;
	private int interviewId = 7;

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
	
	//set up Comment
	private Comment commentOne = new Comment(1, new GregorianCalendar(2005, 3, 21), "Not a good interview.",interviewInterviewer1);
	private Comment commentTwo = new Comment(2, new GregorianCalendar(2002, 4, 5), "Pretty good interview.", interviewInterviewer2);
	private Comment commentThree = new Comment(3, new GregorianCalendar(2008, 8, 1), "Great interview!", interviewInterviewer3);

	private List<Comment> fullList = new ArrayList<>();
	private List<Comment> smallList = new ArrayList<>();

	private CommentService service;
	
	@Before
	public void setup() {
		service = Mockito.mock(CommentService.class);
		smallList.add(commentOne);
		fullList.add(commentOne);
		fullList.add(commentTwo);
		fullList.add(commentThree);
		Mockito.when(service.insertCommentWithInterview(interviewId, commentThree)).thenReturn(commentThree);
		Mockito.when(service.findAll()).thenReturn(fullList);
		Mockito.when(service.getCommentsByInterview(interviewId)).thenReturn(smallList);
		ctrl = new CommentController(service);
	}
	
	@Test
	/** Tests that the insertComment method returns the same method that was inserted and that the
	 corresponding service method was called. */
	public void testInsert() {
		System.out.println("Testing insertComment.");
		Comment returnedComment = ctrl.insertComment(interviewId, commentThree);
		Mockito.verify(service, Mockito.times(1)).insertCommentWithInterview(interviewId, commentThree);
		System.out.println("Success: The correct method in the service class was called exactly once.");
		String success = commentThree == returnedComment ? "Success" : "Failure";
		System.out.printf("%s: Return value of insertComment was %s. Expected value was %s.\n", 
				success, returnedComment, commentThree);
		Assert.assertEquals(commentThree, returnedComment);
		System.out.println("Insert test is complete.");
	}
	
	@Test
	/** Tests that the findAll method returns the list of commments provided by the service method, and that the
	 corresponding service method was called. */
	public void testFindAll() {
		System.out.println("Testing findAll.");
		List<Comment> returnedList = ctrl.findAll();
		Mockito.verify(service, Mockito.times(1)).findAll();
		System.out.println("Success: The correct method in the service class was called exactly once.");
		String success = fullList.size() == returnedList.size() ? "Success" : "Failure";
		System.out.printf("%s: Length of returned list was %d. Expected length was %d.\n", 
				success, returnedList.size(), fullList.size());
		Assert.assertEquals(fullList.size(), returnedList.size());
		for (int index = 0; index < fullList.size() && index < returnedList.size(); index++) {
			Comment initialComment = fullList.get(index);
			Comment returnedComment = returnedList.get(index);
			success = initialComment == returnedComment ? "Success" : "Failure";
			String doNot = initialComment == returnedComment ? "matched" : "did not match";
			System.out.printf("%s: At index %d, the expected and returned comments %s.\n", success, index, doNot);
			Assert.assertEquals(success, "Success");
		}
		
		System.out.println("Find all test is complete.");
	}

	@Test
	/** Tests that the findByInterviewId method returns the list of commments provided by the service method, 
	 and that the corresponding service method was called. */
	public void testFindByInterview() {
		System.out.println("Testing findByInterviewId.");
		List<Comment> returnedList = ctrl.findByInterviewId(interviewId);
		Mockito.verify(service, Mockito.times(1)).getCommentsByInterview(interviewId);
		System.out.println("Success: The correct method in the service class was called exactly once.");
		String success = smallList.size() == returnedList.size() ? "Success" : "Failure";
		System.out.printf("%s: Length of returned list was %d. Expected length was %d.\n", 
				success, returnedList.size(), smallList.size());
		Assert.assertEquals(smallList.size(), returnedList.size());
		for (int index = 0; index < smallList.size() && index < returnedList.size(); index++) {
			Comment initialComment = smallList.get(index);
			Comment returnedComment = returnedList.get(index);
			success = initialComment == returnedComment ? "Success" : "Failure";
			String doNot = initialComment == returnedComment ? "matched" : "did not match";
			System.out.printf("%s: At index %d, the expected and returned comments %s.\n", success, index, doNot);
			Assert.assertEquals(success, "Success");
		}
		System.out.println("Find by interview test is complete.");
	}
}
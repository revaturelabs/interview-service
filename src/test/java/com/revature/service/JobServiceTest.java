package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.h2.mvstore.Page;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.data.domain.PageRequest;

import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.Skill;
import com.revature.repository.JobRepository;

/*
 * Test class for JobService. Rewritten to utilize Mockito. This one has JORBS.
 * @author: redc
 * @created: 13JAN2020
 */

public class JobServiceTest {
	
	//Mockito starter stuff.
	@Rule
	public MockitoRule mockRule = MockitoJUnit.rule();
	
	@Mock
	JobRepository jobRep;
	
	@InjectMocks
	JobService jobServ;

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
	}

	//CONSTRUCTORS
	
	@Test
	public void testJobService() {
		System.out.println("in JobService()");
		
		JobService testServ = new JobService();
		if (testServ.getClass() != JobService.class)
		{
			fail("Constructor not working.");
		}	
	}

	@Test
	public void testJobServiceJobRepository() {
		System.out.println("in JobService(JobRepository)");
		
		JobService testServ = new JobService(jobRep);
		if (testServ.getClass() != JobService.class)
		{
			fail("POR QUE?!");
		}	
	}

	//METHODS
	
	@Test
	public void testInsertJobInfo() {
		System.out.println("In insertJobInfo");
		
		Job testJob = Mockito.mock(Job.class);
		testJob.setTitle("Senior Custodial Manager");
		testJob.setDescription("You clean up things.");
	
		Boolean request = jobServ.insertJobInfo(testJob);
		
		assertTrue(request);
		verify(jobRep, times(1)).save(testJob);
	}

	// TODO: Test throws assertion error. Check routing. May need to check equality between getter and testJob.
	@Test
	public void testUpdateJobInfo() {
		System.out.println("In updateJobInfo");
		
		Job testJob = Mockito.mock(Job.class);
		testJob.setId(1);
		testJob.setTitle("Senior Custodial Manager");
		testJob.setDescription("You clean up things.");
		
		this.jobServ.insertJobInfo(testJob);
	
		//Boolean request = jobServ.insertJobInfo(testJob);
		
		Job updateJob = testJob;
		updateJob.setDescription("Just kidding, you manage the people that clean up things.");
		
		Boolean updateReq = this.jobServ.updateJobInfo(updateJob);
		
		Job reqJob = this.jobServ.findById(1);
		
		assertEquals(reqJob, updateJob);
		
		//assertTrue(updateReq);
		verify(jobRep, times(1)).save(updateJob);
	}

	@Test
	public void testGetAllJobs() {
		System.out.println("in getAllJobs");
		
		List<Job> jobList = new ArrayList<Job>();
		Job jobA = Mockito.mock(Job.class);
		jobA.setId(0);
		jobA.setTitle("Manager");
		jobList.add(jobA);
		
		Job jobB = Mockito.mock(Job.class);
		jobB.setId(1);
		jobB.setTitle("Assistant Manager");
		jobList.add(jobB);

		
		Job jobC = Mockito.mock(Job.class);
		jobC.setId(2);
		jobC.setTitle("Assistant to the Assistant Manager");
		jobList.add(jobC);
		
		when(jobRep.findAll()).thenReturn(jobList);
		
		Iterable<Job> reqList = jobServ.getAllJobs();
		
		assertEquals(reqList, jobList);
		verify(jobRep, times(1)).findAll();
	}

	// TODO: Figure out cause of NullPointerException. Alter tester once solution has been found.
	@Test
	public void testGetAllJobsPaged() {
		System.out.println("in getAllJobsPaged");
		
		List<Job> jobList = new ArrayList<Job>();
		Job jobA = Mockito.mock(Job.class);
		jobA.setId(3);
		jobA.setTitle("Manager");
		jobList.add(jobA);
		
		Job jobB = Mockito.mock(Job.class);
		jobB.setId(4);
		jobB.setTitle("Assistant Manager");
		jobList.add(jobB);

		
		Job jobC = Mockito.mock(Job.class);
		jobC.setId(5);
		jobC.setTitle("Assistant to the Assistant Manager");
		jobList.add(jobC);
			
		when(jobRep.findAll(PageRequest.of(0, 10)).getContent()).thenReturn(jobList);
		//when(jobServ.getAllJobsPaged(3)).thenReturn(jobList);
		
		List<Job> reqList = jobServ.getAllJobsPaged(0);
		
		assertEquals(reqList, jobList);
		verify(jobRep, times(1)).findAll(PageRequest.of(0, 10)).getContent();
	}

	@Test
	public void testFindById() {
		System.out.println("in findById");
		
		Job testJob = Mockito.mock(Job.class);
		testJob.setId(1);
		testJob.setTitle("Number Cruncher");
		
		when(jobRep.findById(1)).thenReturn(testJob);
		
		Job reqJob = jobServ.findById(1);
		
		assertEquals(reqJob, testJob);
		verify(jobRep, times(1)).findById(1);
	}

	@Test
	public void testFindByTitle() {
		System.out.println("in findByTitle");
		
		Job testJob = Mockito.mock(Job.class);
		testJob.setId(0);
		testJob.setTitle("Title Holder");
		
		when(jobRep.findByTitle("Title Holder")).thenReturn(testJob);
		
		Job reqJob = jobServ.findByTitle("Title Holder");
		
		assertEquals(reqJob, testJob);
		verify(jobRep, times(1)).findByTitle("Title Holder");
	}

	// Redundant. Method is exactly identical to getAllJobs. Suggest removal. -redc
	@Test
	public void testFindAll() {
System.out.println("in findAll");
		
		List<Job> jobList = new ArrayList<Job>();
		Job jobA = Mockito.mock(Job.class);
		jobA.setId(0);
		jobA.setTitle("Manager");
		jobList.add(jobA);
		
		Job jobB = Mockito.mock(Job.class);
		jobB.setId(1);
		jobB.setTitle("Assistant Manager");
		jobList.add(jobB);

		
		Job jobC = Mockito.mock(Job.class);
		jobC.setId(2);
		jobC.setTitle("Assistant to the Assistant Manager");
		jobList.add(jobC);
		
		when(jobRep.findAll()).thenReturn(jobList);
		
		Iterable<Job> reqList = jobServ.findAll();
		
		assertEquals(reqList, jobList);
		verify(jobRep, times(1)).findAll();
	}

	@Test
	public void testFindByTitlePaged() {
System.out.println("in findByTitlePaged");
		
		List<Job> testList = new ArrayList<Job>();
		Job testJob = Mockito.mock(Job.class);
		testJob.setId(5);
		testJob.setTitle("Title Holder");
		
		testList.add(testJob);
		
		when(jobRep.findByTitle("Title Holder", PageRequest.of(0, 10))).thenReturn(testList);
		
		List<Job> reqList = jobServ.findByTitlePaged("Title Holder", 0);
		
		assertEquals(reqList, testList);
		verify(jobRep, times(1)).findByTitle("Title Holder", PageRequest.of(0, 10));
	}

}

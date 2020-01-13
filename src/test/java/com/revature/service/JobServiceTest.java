package com.revature.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.revature.model.Job;
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
		Job testJob = new Job();
		
		testJob.setTitle("Senior Custodial Manager");
		testJob.setDescription("You clean up things.");
		
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateJobInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllJobs() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllJobsPaged() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByTitlePaged() {
		fail("Not yet implemented");
	}

}

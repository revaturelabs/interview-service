package com.revature.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.revature.controller.JobController;
import com.revature.controller.SkillController;
import com.revature.model.Job;
import com.revature.model.Skill;
import com.revature.service.JobService;
import com.revature.service.SkillService;

/**
 * Tests that the JobController Methods are calling their respective services
 * 
 * @return test results in the Junit console that verify that JobService methods are being called
 * @author King David
 *
 */

public class JobControllerTest {
	JobController jc;
	SkillController sc;
	Set<Skill> skills;
//	JobService jobServ = Mockito.mock(JobService.class);
//	SkillService skillServ = Mockito.mock(SkillService.class);
	@Rule 
	public MockitoRule mockRule = MockitoJUnit.rule();
	@Mock
	private JobService jobServ;
	@Mock
	private SkillService skillServ;
	
	
	@Before
	public void setUp() throws Exception {
		//JobController jc = Mockito.mock(JobController.class);
		jc = new JobController(jobServ, skillServ);
		System.out.println(jc);
		
	}
	
	@Test
	public void testGetByTitle() {
		Job jb = new Job(1,"head","it me","here", skills, true);
		Mockito.when(jobServ.findByTitle("head")).thenReturn(jb);
		System.out.println("called");
		System.out.println(jb);
		assertEquals(jb, jc.getByTitle("head"));
		Mockito.verify(jobServ).findByTitle("head");
		
	}
	
	@Test
	public void testUpdateJob() {
		Job jb1 = new Job();
		Mockito.when(jobServ.updateJobInfo(jb1)).thenReturn(true);
		assertEquals(true, jc.updateJobInfo(jb1));
		Mockito.verify(jobServ).updateJobInfo(jb1);
	}
	@Test
	public void testInsertJob() {
		Job jb2 = new Job();
		Mockito.when(jobServ.insertJobInfo(jb2)).thenReturn(true);
		assertEquals(true, jc.insertJobInfo(jb2));
		Mockito.verify(jobServ).insertJobInfo(jb2);
	}
	
	@Test 
	public void testGetAll() {
		List<Job> jobs = new ArrayList<Job>();
		Mockito.when(jobServ.findAll()).thenReturn(jobs);
		assertEquals(jobs, jc.getAll());
		Mockito.verify(jobServ).findAll();
	}
	
}

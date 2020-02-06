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
		List<Job> jb = new ArrayList<>();
		jb.add(new Job(1,"head","it me","here", skills, true));
		Mockito.when(jobServ.findByTitle("head")).thenReturn(jb);
		System.out.println("called");
		System.out.println(jb);
		assertEquals(jb, jc.getByTitle("head"));
		Mockito.verify(jobServ).findByTitle("head");
		
	}
	
//	@Test
//	public void testInsertJob() {
//		Job jb2 = new Job();
//		Mockito.when(jobServ.insertJobInfo(jb2)).thenReturn(true);
//		assertEquals(true, jc.insertJobInfo(jb2));
//		Mockito.verify(jobServ).insertJobInfo(jb2);
//	}
	
	@Test 
	public void testGetAll() {
		List<Job> jobs = new ArrayList<Job>();
		Mockito.when(jobServ.findAll()).thenReturn(jobs);
		assertEquals(jobs, jc.getAll());
		Mockito.verify(jobServ).findAll();
	}
	
	@Test
	public void testPagingGetAll() {
		List<Job> jobs= new ArrayList<>();
		for(int i = 0; i < 500; i++)
		{
			String titleBuilder= "";
			titleBuilder += (char)('k' + (i+39)%128);
			titleBuilder += (char)('e' + (i-4)%128);
			titleBuilder += (char)('O' + (i+7)%128);
			titleBuilder += (char)('n' + (i)%128);
			
			jobs.add(new Job(i, titleBuilder,"test","testland",skills,false));
		}
			
		Mockito.when(jobServ.getAllJobsPaged(0)).thenReturn(jobs.subList(0, 10));
		
		assertEquals(10, jc.getAllPaged(0, false, "", null).size());
		
		Mockito.verify(jobServ).getAllJobsPaged(0);
				
	}

	@Test
	public void testPagingGetbyTitle() {
		List<Job> returnjobs= new ArrayList<>();
		List<Job> jobs= new ArrayList<>();
		jobs.add(new Job(1, "Tery","test","testland",skills,false));
		jobs.add(new Job(2, "Tonny","test","testland",skills,false));
		jobs.add(new Job(0, "Bob","test","testland",skills,false));
		jobs.add(new Job(3, "James","test","testland",skills,false));
		jobs.add(new Job(5, "David","test","testland",skills,false));
		jobs.add(new Job(4, "Tret","test","testland",skills,false));
		returnjobs.add(new Job(4, "Tret","test","testland",skills,false));
		returnjobs.add(new Job(1, "Tery","test","testland",skills,false));
		returnjobs.add(new Job(2, "Tonny","test","testland",skills,false));
		
		Mockito.when(jobServ.findByTitlePaged("T", 0)).thenReturn(returnjobs);
		
		assertEquals(returnjobs, jc.getByTitle("T", 0));
		
		Mockito.verify(jobServ).findByTitlePaged("T", 0);
		
	}
}

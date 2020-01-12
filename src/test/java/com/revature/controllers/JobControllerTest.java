package com.revature.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

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
	public void testGetAll() {
		Job jb = new Job(1,"head","it me","here", skills, true);
		Mockito.when(jobServ.findByTitle("head")).thenReturn(jb);
		System.out.println("called");
		System.out.println(jb);
//		List<Job> jbs = new ArrayList<Job>();
//		Job jb = new Job();
//		jbs.add(jb);
//		System.out.println(jc.getAll());
//		Mockito.when(jc.getAll()).thenReturn(jbs);
		assertEquals("Job [id=1, title=head, description=it me, location=here, skills=null, isFilled=true, profile=null]", jc.getByTitle("head").toString() );
		assertEquals(jb, jc.getByTitle("head"));
		Mockito.verify(jobServ, times(2)).findByTitle("head");
		
	}
	
	
}

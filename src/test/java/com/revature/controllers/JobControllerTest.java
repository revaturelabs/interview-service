
package com.revature.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.controller.JobController;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.Skill;

@SpringBootTest(classes = { JobController.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@ComponentScan("com.revature.service")
@EnableAutoConfiguration
// @EnableFeignClients(clients = { AuthInterface.class })
@TestPropertySource(locations = "classpath:application-test.properties")
public class JobControllerTest {
	/**
	 * JUnit tests for the Job Controller object
	 * @author John Thaddeus Kelly
	 */
	
	@Autowired
	JobController jc;
	Job job1 = new Job(1, "Avenger", "Saving the World", new ArrayList<Skill>(), true, new ArrayList<Profile>());
	Job job2 = new Job(2, "Justice League", "Rescuing the World", new ArrayList<Skill>(), true, new ArrayList<Profile>());
	Job job3 = new Job(3, "Villain", "Destroying the World", new ArrayList<Skill>(), true, new ArrayList<Profile>());
	
	@Before
	public void setup() {
		jc.insertJobInfo(job1);
		jc.insertJobInfo(job2);
		jc.insertJobInfo(job3);
	}
	
	@Test
	public void testSetup() {
		assertTrue(jc.insertJobInfo(job3));
	}
	
	@Test
	public void testGetAll() {
		List<Job> list = new ArrayList<Job>();
		list.add(job1);
		list.add(job2);
		list.add(job3);
		assertEquals(list, jc.getAll());
		// assertTrue(list.contains(job2));
	}
	
	@Test
	public void testGetTitle() {
		assertEquals(job1, jc.getByTitle("Avenger"));
	}
	
	@Test
	public void testUpdate() {
		assertTrue(jc.updateJobInfo(new Job(1, "Avenger", "Defending the World", new ArrayList<Skill>(), true, new ArrayList<Profile>())));
	}
}

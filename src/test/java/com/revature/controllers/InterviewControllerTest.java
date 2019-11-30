package com.revature.controllers;

import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.model.Interview;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.User;

@SpringBootTest(classes = { InterviewController.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@ComponentScan("com.revature.service")
@EnableAutoConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class InterviewControllerTest {
	@Autowired
	InterviewController ic;
	Interview interview1 = new Interview();
	Interview interview2 = new Interview();
	Interview interview3 = new Interview();
	
	@Before
	public void setup() {
		ic.saveInterview(interview1);
		ic.saveInterview(interview2);
	}
	
	@Test
	public void testSetup() {
		assertTrue(ic.saveInterview(interview3));
	}
	
	@Test
	public void testGetAll() {
		ArrayList<Interview> list = (ArrayList<Interview>) ic.getAll();
		assertTrue(list.contains(interview1));
	}
}

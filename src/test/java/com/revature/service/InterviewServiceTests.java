package com.revature.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.model.Interview;

@SpringBootTest(classes = {InterviewService.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class InterviewServiceTests {
	
	/**
	 * Unit tests for the Interview Service object
	 * @author John Thaddeus Kelly
	 */

	@Autowired
	private InterviewService is;
	
	@Test
	public void testSaveInterview() {
		Interview interview = new Interview();
		assertTrue(is.insertInterviewInfo(interview));
	}
	
	@Test
	public void testBadInterview() {
		assertFalse(is.insertInterviewInfo(null));
	}
	
	@Test
	public void testGetAll() {
		assertNotNull(is.getAllInterviews());
	}
	
}

/*
 * package com.revature.service;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.junit.Assert.assertFalse; import static org.junit.Assert.assertNotNull;
 * import static org.junit.Assert.assertTrue;
 * 
 * import java.util.ArrayList;
 * 
 * import org.junit.Before; import org.junit.Test; import
 * org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.autoconfigure.EnableAutoConfiguration; import
 * org.springframework.boot.autoconfigure.domain.EntityScan; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.data.jpa.repository.config.EnableJpaRepositories; import
 * org.springframework.test.context.TestPropertySource; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.revature.model.Job; import com.revature.model.Profile; import
 * com.revature.model.Skill;
 * 
 * @SpringBootTest(classes = {JobService.class}, webEnvironment =
 * SpringBootTest.WebEnvironment.RANDOM_PORT)
 * 
 * @EnableJpaRepositories("com.revature.repository")
 * 
 * @EntityScan("com.revature.model")
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @EnableAutoConfiguration
 * 
 * @TestPropertySource(locations = "classpath:application-test.properties")
 * public class JobServiceTest {
 * 
 *//**
	 * Unit tests for the Job Service object
	 * 
	 * @author John Thaddeus Kelly
	 *//*
		 * 
		 * @Autowired private JobService js; Job job1 = new Job(1, "Avenger",
		 * "Saving the World", new ArrayList<Skill>(), true, new ArrayList<Profile>());
		 * 
		 * @Before public void setup() { js.insertJobInfo(job1); }
		 * 
		 * @Test public void testInsertJob() { Job job = new Job();
		 * assertTrue(js.insertJobInfo(job)); }
		 * 
		 * @Test public void testBadInsertJob() { assertFalse(js.insertJobInfo(null)); }
		 * 
		 * @Test public void testUpdateJob() { assertTrue(js.updateJobInfo(job1)); }
		 * 
		 * @Test public void testBadJob() { assertFalse(js.updateJobInfo(null)); }
		 * 
		 * @Test public void testAllJobs() { assertNotNull(js.getAllJobs()); }
		 * 
		 * @Test public void testFindAll() { assertNotNull(js.findAll()); }
		 * 
		 * @Test public void testGetTitle() { assertEquals(job1,
		 * js.findByTitle("Avenger")); }
		 * 
		 * @Test public void testGetId() { assertEquals(job1, js.findById(1)); } }
		 */
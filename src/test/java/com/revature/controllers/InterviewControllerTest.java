/*
 * package com.revature.controllers;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.junit.Assert.assertTrue;
 * 
 * import java.sql.Timestamp; import java.time.Instant; import
 * java.util.ArrayList; import java.util.HashSet; import java.util.List;
 * 
 * import org.junit.Before; import org.junit.Test; import
 * org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.autoconfigure.EnableAutoConfiguration; import
 * org.springframework.boot.autoconfigure.domain.EntityScan; import
 * org.springframework.boot.test.context.SpringBootTest; //import
 * org.springframework.cloud.openfeign.EnableFeignClients; import
 * org.springframework.context.annotation.ComponentScan; import
 * org.springframework.data.jpa.repository.config.EnableJpaRepositories; import
 * org.springframework.test.context.TestPropertySource; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.revature.controller.InterviewController; import
 * com.revature.model.Comment; import com.revature.model.Interview; import
 * com.revature.model.Job; import com.revature.model.Profile; import
 * com.revature.model.Skill; import com.revature.model.User;
 * 
 * @SpringBootTest(classes = { InterviewController.class }, webEnvironment =
 * SpringBootTest.WebEnvironment.RANDOM_PORT)
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @EnableJpaRepositories("com.revature.repository")
 * 
 * @EntityScan("com.revature.model")
 * 
 * @ComponentScan("com.revature.service")
 * 
 * @EnableAutoConfiguration
 * 
 * @TestPropertySource(locations = "classpath:application-test.properties")
 * public class InterviewControllerTest {
 * 
 * @Autowired InterviewController ic = new InterviewController();
 * 
 * Profile profile1 = new Profile(1, "Fred", "Jenkins", new HashSet<Skill>(),
 * null, "description"); Profile profile2 = new Profile(2, "testfirst",
 * "testlast", new HashSet<Skill>(), null, "description"); Profile profile3 =
 * new Profile(3, "anotherone", "anotherone", new HashSet<Skill>(), null,
 * "description"); Job job1 = new Job(1, "title1", "description", new
 * ArrayList<Skill>(), true, new ArrayList()); Job job2 = new Job(2, "title1",
 * "description", new ArrayList<Skill>(), true, new ArrayList()); Job job3 = new
 * Job(3, "title1", "description", new ArrayList<Skill>(), true, new
 * ArrayList());
 * 
 * Interview interview1 = new Interview(1, profile1, new ArrayList<Comment>(),
 * Timestamp.from(Instant.now()), true, job1, new HashSet<User>()); Interview
 * interview2 = new Interview(2, profile2, new ArrayList<Comment>(),
 * Timestamp.from(Instant.now()), true, job2, new HashSet<User>()); Interview
 * interview3 = new Interview(3, profile3, new ArrayList<Comment>(),
 * Timestamp.from(Instant.now()), true, job3, new HashSet<User>());
 * 
 * @Before public void setUp() {
 * 
 * ic.saveInterview(interview1); ic.saveInterview(interview2); }
 * 
 * @Test public void testSetup() {
 * 
 * assertTrue(ic.saveInterview(interview3)); }
 * 
 * @Test public void testgetAll() {
 * 
 * List<Interview> list = new ArrayList<>(); list.add(interview1);
 * list.add(interview2);
 * 
 * assertEquals(list.iterator().next(), ic.getAll().iterator().next()); }
 * 
 * @Test public void getById() {
 * 
 * assertEquals(ic.getById(1).getId(), interview1.getId());
 * 
 * }
 * 
 * }
 */

/*
 * package com.revature.service;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.junit.Assert.assertFalse; import static org.junit.Assert.assertNotNull;
 * import static org.junit.Assert.assertTrue;
 * 
 * import java.util.HashSet; import java.util.Set;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.autoconfigure.EnableAutoConfiguration; import
 * org.springframework.boot.autoconfigure.domain.EntityScan; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.data.jpa.repository.config.EnableJpaRepositories; import
 * org.springframework.test.context.TestPropertySource; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.revature.model.Interview; import com.revature.model.Profile;
 * import com.revature.model.Skill;
 * 
 * @SpringBootTest(classes = {ProfileService.class}, webEnvironment =
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
 * public class ProfileServiceTest {
 *//**
	 * Unit tests for the Profile Service object
	 * 
	 * @author John Thaddeus Kelly
	 *//*
		 * @Autowired ProfileService ps;
		 * 
		 * @Test public void testInsertProfile() {
		 * 
		 * Set<Skill> skills = new HashSet<>(); skills.add(new Skill()); Set<Interview>
		 * interviews = new HashSet<>(); interviews.add(new Interview());
		 * 
		 * Profile p = new Profile(); assertTrue(ps.insertProfileInfo(p)); }
		 * 
		 * @Test public void testBadInsertProfile() {
		 * assertFalse(ps.insertProfileInfo(null)); }
		 * 
		 * @Test public void testFindAll() { assertNotNull(ps.getAllProfiles()); }
		 * 
		 * @Test public void testFindId() { Profile profile1 = new Profile(1, "Bruce",
		 * "Banner", new HashSet<Skill>(), new HashSet<Interview>(), "description");
		 * ps.insertProfileInfo(profile1); assertEquals(profile1, ps.findById(1)); } }
		 */
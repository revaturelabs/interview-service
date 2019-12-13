
package com.revature.controllers;

/**
 * @author Janel Williams 12/12/2019
 * Junit test Skill controller methods. 
 * Passed in actual values for cleaner tests. 
 * Purposely didn't use assertnotnull because we wanted to make sure the appropriate values were
 * being returned. Assertnotnull will only give us a vague sense. 
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.netflix.discovery.converters.Auto;
import com.revature.controller.ProfileController;
import com.revature.controller.SkillController;
import com.revature.model.Profile;
import com.revature.model.Skill;

@SpringBootTest(classes = { SkillController.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@EnableJpaRepositories("com.revature.repository")
@EntityScan("com.revature.model")
@ComponentScan("com.revature.service")
@EnableAutoConfiguration
// @EnableFeignClients(clients = { AuthInterface.class })
@TestPropertySource(locations = "classpath:application-test.properties")
public class SkillControllerTest {

	@Autowired
	SkillController sc;;
	String title;
	String title1;
	String title2;

	Profile profile1 = new Profile(0, "firstname", "lastname", "description");
	Profile profile2 = new Profile(1, "firstname", "lastname", "description");
	Profile profile3 = new Profile(2, "firstname", "lastname", "description");

	Set<Profile> testProfile= new HashSet<>();
	List<Skill> testSkills = new ArrayList<>();

	Skill skill = new Skill(1, title, testProfile);
	Skill skill2 = new Skill(2, title1, testProfile);
	Skill skill3 = new Skill(3, title2, testProfile);

	@Before
	public void setupController() {
		sc.insertSkill(skill);
		sc.insertSkill(skill2);

		title = "title";
		title1 = "title2";
		title2 = "title3";

		
		testProfile.add(profile1);
		testProfile.add(profile2);
		testProfile.add(profile3);


		testSkills.add(skill);
		testSkills.add(skill2);
		
	}



	@Test
	public void testSkillSetUp() {
		//also tests insertSkill method 
		assertTrue(sc.insertSkill(skill3));
		
	}



	@Test
	public void testgetBySkill(){
		assertEquals(sc.getBySkill(2).getId(), skill2.getId());

	}



	@Test
	public void testGetAll() {

		assertEquals(sc.getSkills().iterator().next().getId(), testSkills.iterator().next().getId());
	}


}

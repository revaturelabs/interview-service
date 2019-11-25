package com.revature;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.model.Interview;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.model.Skill;
import com.revature.repository.InterviewRepository;
import com.revature.repository.JobRepository;
import com.revature.repository.ProfileRepository;
import com.revature.repository.SkillRepository;

/*	Integration testing for the Job Repository
 * @author John Thaddeus Kelly
 */

@SpringBootTest(classes = {JobRepository.class, SkillRepository.class, ProfileRepository.class, InterviewRepository.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class InterviewServiceApplicationTests {
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private InterviewRepository interviewRepository;
	
	@Test
	public void jobWhenFindAll_thenReturn() {
		
		List<Job> found = (List<Job>) jobRepository.findAll();
		
		assertNotNull(found);
	}
	@Test
	public void jobWhenFindSearch_thenReturn() {
		List<Job> found = (List<Job>) jobRepository.findByTitle("Code" + "%");
		assertNotNull(found);
	}
	@Test
	public void skillWhenFindAll_thenReturn() {
		List<Skill> found = (List<Skill>) skillRepository.findAll();
		
		assertNotNull(found);
	}
	@Test
	public void profileWhenFindAll_thenReturn() {
		List<Profile> found = (List<Profile>) profileRepository.findAll();
		
		assertNotNull(found);
	}
	@Test
	public void interviewWhenFindAll_thenReturn() {
		List<Interview> found = (List<Interview>) interviewRepository.findAll();
		
		assertNotNull(found);
	}
}

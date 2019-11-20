package com.revature;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.model.Job;
import com.revature.repository.JobRepository;

/*	Integration testing for the Job Repository
 * @author John Thaddeus Kelly
 */

@SpringBootTest(classes = {JobRepository.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class InterviewServiceApplicationTests {
	@MockBean
	private TestEntityManager entityManager;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Test
	public void whenFindAll_thenReturn() {
		Job thisJob = new Job();
		entityManager.persist(thisJob);
		entityManager.flush();
		
		List<Job> found = (List<Job>) jobRepository.findAll();
		
		assertThat(found).contains(thisJob);
	}
}

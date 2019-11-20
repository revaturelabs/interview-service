package com.revature;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.model.Job;
import com.revature.repository.JobRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
//@WebMvcTest(JobController.class)
@ContextConfiguration(classes = InterviewServiceApplication.class)
/*@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
	classes = InterviewServiceApplication.class)*/
//@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application-test.properties")
public class InterviewServiceApplicationTests {
	
	@Autowired
	private TestEntityManager entityManager;
	//MockMvc mocMvc;
	
	@Autowired
	JobRepository jr;
	
	@Test
	public void whenFindAll_thenReturn() {
		Job thisJob = new Job();
		entityManager.persist(thisJob);
		entityManager.flush();
		
		List<Job> found = (List<Job>) jr.findAll();
		
		assertNotNull(found);
	}
	
	/*@Test
	public void getAll() throws Exception{
		Mockito.when(jr.findAll()).thenReturn(Collections.emptyList());
		
		this.mocMvc.perform(
				MockMvcRequestBuilders.get("/jobs/jobAll")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		verify(jr).findAll();
	}*/

}

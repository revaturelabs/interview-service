package com.revature;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.model.Interview;
import com.revature.repo.RepoInterview;
import com.revature.service.ServiceInterview;

@RunWith(SpringRunner.class)
@WebMvcTest					//@SpringBootTest
public class InterviewServiceApplicationTests {
	
	@Autowired
	MockMvc mocMvc;
	
	@MockBean
	RepoInterview repoI;
	
	@Test
	public void GetAll() throws Exception {
		
		Mockito.when(repoI.findAll()).thenReturn(Collections.emptyList());
		
		MvcResult mvcResult = mocMvc.perform(
				MockMvcRequestBuilders.get("/all")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		System.out.println("OK!" + mvcResult.getResponse().getStatus());
		
		Mockito.verify(repoI).findAll();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@Autowired
//	private ServiceInterview serviceI;
//	
//	@MockBean
//	private RepoInterview repoI;
//	
//	@Test
//	public void getInterviewsTest(){
//		
//		when(repoI.findAll()).thenReturn(Stream.of(new Interview(5,null,null,null,true,null,null), new Interview(6,null,null,null,false,null,null)).collect(Collectors.toList()));
//		assertEquals(2,serviceI.getInterviews().size());
//		
//	}
//	
	
	
//	@Test
//	public void saveInterviewTest() {
//		Interview inter = new Interview(99,null,null,null,true,null,null);
//		when(repoI.save(inter)).thenReturn(inter);
//		assertEquals(inter, serviceI.addInterview(inter));
//	}
//	
	
	
	
	
	
	
	
	
//	@Test
//	public void contextLoads() {
//	}

}

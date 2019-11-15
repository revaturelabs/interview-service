package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Interview;
import com.revature.repo.RepoInterview;
import com.revature.service.ServiceInterview;

@RestController
@RequestMapping("/interview")
public class ControlInterview {
	
	//@Autowired
	private RepoInterview repoI;
	
	public ControlInterview(RepoInterview repoI) {
		this.repoI =repoI;
	}
	
	@GetMapping("/getAll")
	public List<Interview> all() {
		return (List<Interview>) repoI.findAll();
	}
	
	
	
//	private ServiceInterview serviceI;
//	
//	@PostMapping(value ="/save")
//	public Interview inter(@RequestBody Interview inT) {
//		return serviceI.addInterview(inT);
//	}
//
//	@GetMapping("/getInterviews")
//	public List<Interview> findAllInterviews(){
//		
//		return serviceI.getInterviews();
//	}
	
	
	
}

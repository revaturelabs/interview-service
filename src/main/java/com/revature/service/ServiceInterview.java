package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Interview;
import com.revature.repo.RepoInterview;

@Service
public class ServiceInterview {
	
	@Autowired
	private RepoInterview repoI;

	public Interview addInterview(Interview inT) {
	
		return repoI.save(inT);
	}

	public List<Interview> getInterviews() {
		List<Interview> inter = (List<Interview>) repoI.findAll(); //casting
		return inter;
	}
	
	

}

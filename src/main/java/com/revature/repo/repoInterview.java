package com.revature.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.model.Interview;

public interface RepoInterview extends CrudRepository<Interview, Integer>{
	
	List<Interview> findById(int id);
}

//	public Interview save(Interview inT) {
//		// TODO Auto-generated method stub
//		return null;
//	}



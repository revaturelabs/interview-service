package com.revature.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.revature.model.Job;

public class CustomJobRepoImpl implements CustomJobRepo{
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void mergeJob(Job job) {
		entityManager.merge(job);		
	}

}

package com.revature.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Profile;

public class CustomProfileRepoImpl implements CustomProfileRepo{

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Override
	public void mergeProfile(Profile profile) {
		entityManager.merge(profile);
		
	}

}

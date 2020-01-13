package com.revature.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class CustomRepoImpl implements CustomRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void mergeEntity(Object o) {
        entityManager.merge(o);

    }

}
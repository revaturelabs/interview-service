package com.revature.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Skill;

/**
 * 
 * @author Seacriest Brown
 *		Repository to retrieve skills from the database.
 */
@Repository
public interface SkillRepository extends CrudRepository<Skill,Integer>{}

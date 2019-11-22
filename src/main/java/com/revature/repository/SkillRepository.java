package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Skill;

/**
 * Repository to retrieve skills from the database.
 * @author Seacriest Brown
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill,Integer>{
	
}
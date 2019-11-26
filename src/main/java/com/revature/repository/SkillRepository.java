package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Skill;

/**
 * Repository to retrieve skills from the database.
 * @author Seacriest Brown
 * @author John Thaddeus Kelly
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill,Integer>{
	Skill findByTitle(String title);
	List<Skill> findByTitleOrderByTitleAsc(String title);
}
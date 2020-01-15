package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.model.Interview;

/**
 * A simple Interview Repo Interface.
 * 
 * @author Davin Merry
 * @author Adriana Long
 */
@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer>, CustomRepo {
	Interview findById(int id);
	
	List<Interview> findByProfile_id(int id);
	
	@Query("select i from Interview i where year(i.date) = ?1 and month(i.date) = ?2")
	List<Interview> findAllByDate(int year, int month);
}

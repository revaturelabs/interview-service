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
public interface InterviewRepository extends JpaRepository<Interview, Integer> {
	
	/** Retrieves an interview from the database that matches the provided ID. 
	 Returns null if no such interview can be found.
	 * @param id The integer that uniquely identifies the interview. 
	 * @return The interview whose ID matches the one provided, or null if no matching interview is found. */
	Interview findById(int id);
	
	/** Returns a list of interviews that a candidate has been scheduled for, based on that candidate's ID. 
	 * @param id The integer that uniquely identifies the candidate. 
	 * @return A list of interviews that the candidate has been scheduled for. */
	List<Interview> findByProfile_id(int id);
	
	/** Returns a list of interviews for a given job opening, based on that job's ID.
	 * @param id The integer that uniquely identifies the job.
	 * @return A list of past, present, and future interviews for the job. */
	List<Interview> findByJob_id(int id);
	
	/** Returns a list of the interviews scheduled to take place within a given year.
	 * @param year An integer representing the Gregorian year when the interview is scheduled to take place.
	 All digits of the year must be included, e.g. the year 1999 must be entered as "1999" not "99". 
	 * @return A list of the interviews scheduled to take place within a given year. */
	@Query("select i from Interview i where year(i.date) = ?1")
	List<Interview> findAllByDate(int year);
	
	/** Returns a list of the interviews scheduled to take place within a given month.
	 * @param year An integer representing the Gregorian year when the interview is scheduled to take place.
	 All digits of the year must be included, e.g. the year 1999 must be entered as "1999" not "99". 
	 * @param month An integer ranging from 1 to 12 representing the month of the year when the interview
	 is scheduled to take place. 
	 * @return A list of the interviews scheduled to take place within a given month. */
	@Query("select i from Interview i where year(i.date) = ?1 and month(i.date) = ?2")
	List<Interview> findAllByDate(int year, int month);
	
	/** Returns a list of the interviews scheduled to take place on a given day. 
	 * @param year An integer representing the Gregorian year when the interview is scheduled to take place.
	 All digits of the year must be included, e.g. the year 1999 must be entered as "1999" not "99". 
	 * @param month An integer ranging from 1 to 12 representing the month of the year when the interview
	 is scheduled to take place.
	 * @param day The day of the month when the interview is scheduled to take place. 
	 * @return A list of the interviews scheduled to take place on a given day. */
	@Query("select i from Interview i where year(i.date) = ?1 and month(i.date) = ?2 and day(i.date) = ?3")
	List<Interview> findAllByDate(int year, int month, int day);

}

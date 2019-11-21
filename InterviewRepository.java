package com.revature.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.model.Interview;


/**
 * An object representation of our Interview model.
 * 
 * [TODO] If you are adding on to this or incorporating Spring Data, please add your name to the author list.
 * @author Adriana Long
 * @author 
 */

public interface InterviewRepository extends CrudRepository <Interview, Long> {
	
	Interview findById(int id);
	

}
package com.revature.repo;

import org.springframework.data.repository.CrudRepository;

import com.revature.model.Interview;

/**
 * An object representation of our Interview model.
 * 
 * [TODO] If you are adding on to this or incorporating Spring Data, please add your name to the author list.
 * @author Adriana Long
 * @author 
 */

public interface ProfileRepository extends CrudRepository <Interview, Long>{

}

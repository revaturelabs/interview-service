package com.revature.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Skill;

/** Repository to retrieve skills from the database.
 * @author Seacriest Brown
 * @author John Thaddeus Kelly */
@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
	
	/** Retrieves the skill from the database whose ID matches the provided number.
	 Returns null if no such skill is found.
	 * @param id The integer that uniquely identifies the skill.
	 * @return The skill from the database whose ID matches the provided number,
	 or null if no such skill is found.  */
	Skill findById(int id);

	/** Retrieves a list of all skills whose name starts with the provided string,
	 ignoring upper and lower case.
	 * @param title A string that will filter out all skills whose names do not start with that string,
	 ignoring upper and lower case.
	 * @return A list of all skills whose name starts with the provided string,
	 ignoring upper and lower case. */
	List<Skill> findByTitleStartsWithIgnoreCase(String title);

	/** Retrieves a list of all skills on a given page whose name starts with the provided string,
	 ignoring upper and lower case.
	 * @param title A string that will filter out all skills whose names do not start with that string,
	 ignoring upper and lower case.
	 * @param page The page that will be searched for matching skills. Any skill outside this page will
	 not be returned in the results list, even if its name starts with the title parameter.
	 * @return A list of all skills on a given page whose name starts with the provided string,
	 ignoring upper and lower case. */
	List<Skill> findByTitleStartsWithIgnoreCase(String title, Pageable page);
}

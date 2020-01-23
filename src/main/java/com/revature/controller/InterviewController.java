package com.revature.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Interview;
import com.revature.model.User;
import com.revature.service.InterviewService;
import com.revature.service.UserService;

/** The main controller for obtaining information about an Interview from the
 * database.
 * @author Davin Merry
 * @author Adriana Long */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/interviews")
public class InterviewController {

	/** An interview service object that performs the business logic for the interview class. */
	private InterviewService interviewService;

	/** A user service object that performs the business logic for the user conducting this interview. */
	private UserService userService;

	/** Creates a new interview controller, setting all its properties to their default values. */
	public InterviewController() {
	}

	
	@Autowired
	/** Creates a new interview controller, setting its properties to the provided values.
	 * @param interviewService An interview service object that performs the business logic for the interview class.
	 * @param userService A user service object that performs the business logic for the user conducting this interview. */
	public InterviewController(InterviewService interviewService, UserService userService) {
		super();
		this.interviewService = interviewService;
		this.userService = userService;
	}

	@PostMapping("/saveInterview")
	/** Saves an interview to the database in response to an HTTP Post request 
	 at the uri "/interviews/saveInterview".
	 * @param interview The interview being scheduled.
	 * @return True if the interview is saved successfully, and false if the interview was not saved. */
	public boolean saveInterview(@RequestBody Interview interview) {
		System.out.println("user added");
		Set<User> users = new HashSet<User>();
		for (User u : interview.getUsers()) {
			User tempUser = userService.findById(u.getId());
			users.add(tempUser);
		}
		interview.setUsers(users);
		return interviewService.insertInterviewInfo(interview);
	}
	@GetMapping("/allInterviews")
	/** Retrieves a list of all interviews in the database in response to an HTTP Get request
	 * at the uri "/interviews/allInterviews".
	 * @return A list of all interviews in the database. */
	public List<Interview> getAll() {
		return interviewService.getAllInterviews();
	}

	@GetMapping("/id/{id}")
	/** Retrieves the interview whose ID matches the provided number, in response to an HTTP Get request
	 at the uri "/interviews/id/{id}" where {id} refers to the interview's unique ID.
	 Returns null if no such interview is found.
	 * @param id The integer that uniquely identifies the interview.
	 * @return The interview whose ID matches the provided number,
	 or null if no such interview is found. */
	public Interview getById(@PathVariable int id) {
		return interviewService.getById(id);
	}
	
	@GetMapping("/job/{id}")
	/** Returns a list of interviews for a job opening whose ID matches the provided number,
	 in response to an HTTP request at the uri "/interviews/job/{id}" where {id} refers to
	 the job's unique ID.
	 * @param id The integer that uniquely identifies the job.
	 * @return A list of interviews for a job opening whose ID matches the provided number. */
	public List<Interview> getByJobId(@PathVariable int id) {
		return interviewService.getInterviewsByJobId(id);
	}
	
	@GetMapping("/profile/{id}")
	/** Returns a list of interviews scheduled for a candidate whose ID matches the provided number,
	 in response to an HTTP request at the uri "/interviews/profile/{id}" where {id} refers to
	 the candidate's unique ID.
	 * @param id The integer that uniquely identifies the candidate.
	 * @return A list of interviews scheduled for a candidate whose ID matches the provided number. */
	public List<Interview> getByProfileId(@PathVariable int id) {
		return interviewService.getInterviewsByProfileId(id);
	}
	
	@GetMapping("/date/{year}")
	/** Returns a list of the interviews scheduled to take place within a given year, 
	 in response to an HTTP request at the uri "/interviews/date/{year}" where {year} refers to
	 the Gregorian year when the interview is scheduled to take place.
	 * @param year An integer representing the Gregorian year when the interview is scheduled to take place.
	 All digits of the year must be included, e.g. the year 1999 must be entered as "1999" not "99". 
	 * @return A list of the interviews scheduled to take place within a given year. */
	public List<Interview> getByDate(@PathVariable("year") int year) {
		return interviewService.getInterviewsByDate(year);
	}
	
	@GetMapping("/date/{year}/{month}")
	/** Returns a list of the interviews scheduled to take place within a given month,
	 in response to an HTTP request at the uri "/interviews/date/{year}/{month}"
	 where {year} refers to the Gregorian year when the interview is scheduled to take place,
	 and {month} refers to an integer ranging from 1 to 12 representing the month of the year when the
	 interview is scheduled to take place.
	 * @param year An integer representing the Gregorian year when the interview is scheduled to take place.
	 All digits of the year must be included, e.g. the year 1999 must be entered as "1999" not "99". 
	 * @param month An integer ranging from 1 to 12 representing the month of the year when the interview
	 is scheduled to take place. 
	 * @return A list of the interviews scheduled to take place within a given month. */
	public List<Interview> getByDate(@PathVariable("year") int year, @PathVariable("month") int month) {
		return interviewService.getInterviewsByDate(year, month);
	}
	
	@GetMapping("/date/{year}/{month}/{day}")
	/** Returns a list of the interviews scheduled to take place on a given day,
	 in response to an HTTP request at the uri "/interviews/date/{year}/{month}/{day}"
	 where {year} refers to the Gregorian year when the interview is scheduled to take place,
	 {month} refers to an integer ranging from 1 to 12 representing the month, and {day} refers to
	 the day of the month.
	 * @param year An integer representing the Gregorian year when the interview is scheduled to take place.
	 All digits of the year must be included, e.g. the year 1999 must be entered as "1999" not "99". 
	 * @param month An integer ranging from 1 to 12 representing the month of the year when the interview
	 is scheduled to take place.
	 * @param day The day of the month when the interview is scheduled to take place. 
	 * @return A list of the interviews scheduled to take place on a given day. */
	public List<Interview> getByDate(@PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("day") int day) {
		return interviewService.getInterviewsByDate(year, month, day);
	}
}

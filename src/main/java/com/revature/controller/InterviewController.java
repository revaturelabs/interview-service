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

/**
 * The main controller for obtaining information about an Interview from the
 * database.
 * 
 * @author Davin Merry
 * @author Adriana Long
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/interviews")

public class InterviewController {

	private InterviewService interviewService;

	private UserService userService;

	public InterviewController() {
	}

	
	@Autowired
	public InterviewController(InterviewService interviewService, UserService userService) {
		super();
		this.interviewService = interviewService;
		this.userService = userService;
	}

	@PostMapping("/saveInterview")
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
	public List<Interview> getAll() {
		return interviewService.getAllInterviews();
	}

	@GetMapping("/id/{id}")
	public Interview getById(@PathVariable int id) {
		return interviewService.getById(id);
	}
	
	@GetMapping("/job/{id}")
	public List<Interview> getByJobId(@PathVariable int id)
	{
		return interviewService.getInterviewsByJobId(id);
	}
	
	@GetMapping("/profile/{id}")
	public List<Interview> getByProfileId(@PathVariable int id) {
		return interviewService.getInterviewsByProfileId(id);
	}
	
	@GetMapping("/date/{year}")
	public List<Interview> getByDate(@PathVariable("year") int year) {
		return interviewService.getInterviewsByDate(year);
	}
	
	@GetMapping("/date/{year}/{month}")
	public List<Interview> getByDate(@PathVariable("year") int year, @PathVariable("month") int month) {
		return interviewService.getInterviewsByDate(year, month);
	}
	
	@GetMapping("/date/{year}/{month}/{day}")
	public List<Interview> getByDate(@PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("day") int day) {
		return interviewService.getInterviewsByDate(year, month, day);
	}
}

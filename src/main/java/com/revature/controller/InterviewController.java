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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Comment;
import com.revature.model.Interview;
import com.revature.model.User;
import com.revature.service.InterviewService;
import com.revature.service.UserServiceImpl;

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

	
	@Autowired
	private InterviewService is;
	@Autowired
	private UserServiceImpl us;

	@PostMapping("/saveInterview")
	public boolean saveInterview(@RequestBody Interview interview) {
		Set<User> users = new HashSet<User>();
		for (User u : interview.getUsers()) {
			User tempUser = us.findById(u.getId());
			users.add(tempUser);
		}
		interview.setUsers(users);
		return is.insertInterviewInfo(interview);
	}

	@PostMapping("/insertComment")
	public boolean insertComment(@RequestParam int id, @RequestBody Comment comment) {
		return is.insertCommentInInterview(id, comment);
	}

	@GetMapping("/allInterviews")
	public List<Interview> getAll() {
		return is.getAllInterviews();
	}

	@GetMapping("/id/{id}")
	public Interview getById(@PathVariable int id) {
		return is.getById(id);
	}
}

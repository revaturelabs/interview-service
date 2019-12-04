package com.revature.controllers;

import com.revature.model.Comment;
import com.revature.model.Interview;
import com.revature.repository.CommentRepository;
import com.revature.service.CommentService;
import com.revature.service.InterviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/comment")
public class CommentController {
    @Autowired
    private CommentService cs;

    @Autowired
    private InterviewService is;

    @PostMapping("/insert")
	public boolean insertComment(@RequestParam int id, @RequestBody Comment comment) {
			return cs.insertCommentWithInterview(id, comment);
    }
    
    @GetMapping("/getByInterview/{id}")
    public Iterable<Comment> findByInterview(@PathVariable int id){
        Interview ic = is.getById(id);
       return cs.findByInterview_Comment(ic);
    }
}
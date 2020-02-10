package com.revature.service;

import java.util.List;

import com.revature.model.Comment;
import com.revature.model.InterviewInterviewer;
import com.revature.repository.CommentRepository;
import com.revature.repository.InterviewInterviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentService {

    private CommentRepository commentRepository;

    private InterviewInterviewerRepository interviewInterviewerRepository;

    public CommentService() {
	}

    @Autowired
    public CommentService(CommentRepository commentRepository, InterviewInterviewerRepository interviewInterviewerRepository) {
		super();
		this.commentRepository = commentRepository;
		this.interviewInterviewerRepository = interviewInterviewerRepository;
	}

	public Comment insertCommentWithInterview(int id, Comment comment) {
        try {
            comment.setInterviewInterviewer(interviewInterviewerRepository.findById(id));
            commentRepository.save(comment);
            return comment;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Comment> getCommentsByInterview(int id) {
    	InterviewInterviewer interviewInterviewer = interviewInterviewerRepository.findById(id);
        if (interviewInterviewer == null) {
            return null;
        } else {
            return commentRepository.findAllByInterviewInterviewer(interviewInterviewer);
        }
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
}
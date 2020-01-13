package com.revature.service;

import java.util.List;

import com.revature.model.Comment;
import com.revature.model.Interview;
import com.revature.repository.CommentRepository;
import com.revature.repository.InterviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    private InterviewRepository interviewRepository;

    public CommentService() {
	}
    
    @Autowired
    public CommentService(CommentRepository commentRepository, InterviewRepository interviewRepository) {
		super();
		this.commentRepository = commentRepository;
		this.interviewRepository = interviewRepository;
	}



	public Comment insertCommentWithInterview(int id, Comment comment) {
        try {
            comment.setInterviewId(interviewRepository.findById(id));
            commentRepository.mergeEntity(comment);
            return comment;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Comment> getCommentsByInterview(int id) {
        Interview interview = interviewRepository.findById(id);
        if (interview == null) {
            return null;
        } else {
            return commentRepository.findAllByInterviewId(interview);
        }
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
}
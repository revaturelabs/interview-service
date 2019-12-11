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

    @Autowired
    private CommentRepository cr;

    @Autowired
    private InterviewRepository ir;

    public Comment insertCommentWithInterview(int id, Comment c) {
        try {
            cr.insertComment(c.getDate(), c.getName(), c.getText(), id);
            return c;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Comment> getCommentsByInterview(int id) {
        Interview i = ir.findById(id);
        if (i == null) {
            return null;
        } else {
            return cr.findAllByInterviewId(i);
        }
    }

    public List<Comment> findAll() {
        return cr.findAll();
    }
}
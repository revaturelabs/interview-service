package com.revature.service;


import com.revature.model.Comment;
import com.revature.model.Interview;
import com.revature.repository.CommentRepository;
import com.revature.repository.InterviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService{

    @Autowired
    private CommentRepository cr;

    @Autowired
    private InterviewRepository ir;

    public boolean insertCommentWithInterview(int id, Comment c) {
    	try {
    		Interview i = ir.findById(id);
    		i.getComments().add(c);
    		ir.save(i);
    		return true;
    	} catch (Exception e) {
    		return false;
    	}
    }

    public Iterable<Comment> findByInterview_Comment(Interview ic){
        if(ic == null){
            return null;
        } else{
            return cr.findByInterview_Comments(ic);
        }
    }



}
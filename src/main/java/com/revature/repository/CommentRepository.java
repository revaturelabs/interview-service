package com.revature.repository;

import java.util.List;

import com.revature.model.Comment;
import com.revature.model.Interview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByInterviewId(Interview interviewId);
}
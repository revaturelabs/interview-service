package com.revature.repository;

import com.revature.model.Comment;
import com.revature.model.Interview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Iterable<Comment> findByInterview_Comments(Interview ic);
}
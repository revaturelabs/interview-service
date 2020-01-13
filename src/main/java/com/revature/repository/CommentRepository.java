package com.revature.repository;

import java.util.List;

import com.revature.model.Comment;
import com.revature.model.Interview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @see Includes all functionality from JpaRepository such as FindAll, FindAllById, etc. 
 * Also includes custom functionality. 
 *
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>, CustomRepo {
    /**
     * @see returns all comments based on interviewId
     */
	List<Comment> findAllByInterviewId(Interview interviewId);

}
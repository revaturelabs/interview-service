package com.revature.repository;

import java.util.List;
import com.revature.model.Comment;
import com.revature.model.InterviewInterviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @see Includes all functionality from JpaRepository such as FindAll, FindAllById, etc. 
 * Also includes custom functionality. 
 *
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
    /**
     * @see returns all comments based on interviewId
     */
	
	List<Comment> findAllByInterviewInterviewer (InterviewInterviewer interviewInterviewer);
}
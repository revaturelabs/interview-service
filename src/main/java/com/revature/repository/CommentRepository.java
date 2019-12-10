package com.revature.repository;

import java.sql.Timestamp;
import java.util.List;

import com.revature.model.Comment;
import com.revature.model.Interview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByInterviewId(Interview interviewId);

    @Query(value = "insert into interview_service.comments (date, name, text, interview_comments) values(?1,?2,?3,?4)", nativeQuery = true)
    void insertComment(Timestamp date, String name, String text, int id);
}
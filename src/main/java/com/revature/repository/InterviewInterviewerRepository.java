package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Interview;
import com.revature.model.InterviewInterviewer;

@Repository
public interface InterviewInterviewerRepository extends JpaRepository <InterviewInterviewer, Integer> {

	InterviewInterviewer findById(int id);

	List<InterviewInterviewer> findByInterview(Interview interview);

	List<InterviewInterviewer> findByInterviewer(String interviewer);
}

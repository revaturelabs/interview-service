package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Interview;
import com.revature.repository.InterviewRepository;

/**
 * The service layer (or business logic) for the Interview object.
 * 
 * @author Adriana Long
 */
@Service
public class InterviewService {

	private InterviewRepository interviewRepository;

	public InterviewService() {
	}
	
	@Autowired
	public InterviewService(InterviewRepository interviewrepo) {
		this.interviewRepository = interviewrepo;
	}

	public boolean insertInterviewInfo(Interview interview) {
		try {
			interviewRepository.mergeEntity(interview);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public List<Interview> getAllInterviews() {
		return interviewRepository.findAll();
	}

	public Interview getById(int id) {
		return interviewRepository.findById(id);
	}
	
	public List<Interview> getInterviewsByProfileId(int id) {
		return interviewRepository.findByProfile_id(id);
	}
	
	public List<Interview> getInterviewsByYearAndMonth(int year, int month) {
		return interviewRepository.findAllByDate(year, month);
	}
}

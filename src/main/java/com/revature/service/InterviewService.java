package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Interview;
import com.revature.model.Job;
import com.revature.model.Profile;
import com.revature.repository.InterviewRepository;
import com.revature.repository.JobRepository;
import com.revature.repository.ProfileRepository;

/**
 * The service layer (or business logic) for the Interview object.
 * 
 * @author Adriana Long
 */
@Service
public class InterviewService {

	private InterviewRepository interviewRepository;
	private JobRepository jobRepo;
	private ProfileRepository proRepo;

	public InterviewService() {
	}
	
	@Autowired
	public InterviewService(InterviewRepository interviewrepo, JobRepository jobRepo, ProfileRepository proRepo) {
		this.interviewRepository = interviewrepo;
		this.jobRepo = jobRepo;
		this.proRepo= proRepo;
	}
	
	@Transactional
	public boolean insertInterviewInfo(Interview interview) {
		try {
			if(interview.getJob()!= null) {
				Job temp = this.jobRepo.findByTitle(interview.getJob().getTitle());
				if(temp != null)
				{
					interview.setJob(temp);
				}
			}
			if(interview.getProfile()!= null) {
				Profile temp = this.proRepo.findById(interview.getProfile().getId());
				if(temp != null)
				{
					interview.setProfile(temp);
				}
			}
			interviewRepository.save(interview);
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
	
	public List<Interview> getInterviewsByJobId(int id)
	{
		return interviewRepository.findByJob_id(id);
	}
	
	public List<Interview> getInterviewsByDate(int year) {
		return interviewRepository.findAllByDate(year);
	}
	
	public List<Interview> getInterviewsByDate(int year, int month) {
		return interviewRepository.findAllByDate(year, month);
	}
	
	public List<Interview> getInterviewsByDate(int year, int month, int day) {
		return interviewRepository.findAllByDate(year, month, day);
	}
}

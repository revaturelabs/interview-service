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

/** The service layer (or business logic) for the Interview object.
 * @author Adriana Long */
@Service
public class InterviewService {

	/** A CRUD repository that links the interview service class to the database. */
	private InterviewRepository interviewRepository;

	/** A CRUD repository for the job that is being applied for during this interview. */
	private JobRepository jobRepo;

	/** A CRUD repository for the candidate who is applying during this interview. */
	private ProfileRepository proRepo;

	/** Creates a new interview service, with all its properties set to their default values. */
	public InterviewService() {
	}

	@Autowired
	/** Creates a new interview service with its properties set to the values provided.
	 * @param interviewrepo A CRUD repository that links the interview service class to the database.
	 * @param jobRepo A CRUD repository for the job that is being applied for during this interview.
	 * @param proRepo A CRUD repository for the candidate who is applying during this interview.
	 * @param userRepo A CRUD repository for the users who are conducting this interview. */
	public InterviewService(InterviewRepository interviewrepo, JobRepository jobRepo, ProfileRepository proRepo) {
		this.interviewRepository = interviewrepo;
		this.jobRepo = jobRepo;
		this.proRepo= proRepo;
	}
	
	@Transactional
	/** Transactionally saves an interview to the database.
	 * @param interview The interview being scheduled.
	 * @return True if the interview is saved successfully, and false if the interview was not saved. */
	public boolean insertInterviewInfo(Interview interview) {
		try {
			if(interview.getJob()!= null) {
				Job temp = this.jobRepo.findById(interview.getJob().getId());
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

	/** Retrieves a list of all interviews in the database.
	 * @return A list of all interviews in the database. */
	public List<Interview> getAllInterviews() {
		return interviewRepository.findAll();
	}

	/** Retrieves the interview whose ID matches the provided number.
	 Returns null if no such interview is found.
	 * @param id The integer that uniquely identifies the interview.
	 * @return The interview whose ID matches the provided number,
	 or null if no such interview is found. */
	public Interview getById(int id) {
		return interviewRepository.findById(id);
	}
	
	/** Returns a list of interviews scheduled for a candidate whose ID matches the provided number.
	 * @param id The integer that uniquely identifies the candidate.
	 * @return A list of interviews scheduled for a candidate whose ID matches the provided number. */
	public List<Interview> getInterviewsByProfileId(int id) {
		return interviewRepository.findByProfile_id(id);
	}
	
	/** Returns a list of interviews for a job opening whose ID matches the provided number.
	 * @param id The integer that uniquely identifies the job.
	 * @return A list of interviews for a job opening whose ID matches the provided number. */
	public List<Interview> getInterviewsByJobId(int id) {
		return interviewRepository.findByJob_id(id);
	}
	
	/** Returns a list of the interviews scheduled to take place within a given year.
	 * @param year An integer representing the Gregorian year when the interview is scheduled to take place.
	 All digits of the year must be included, e.g. the year 1999 must be entered as "1999" not "99". 
	 * @return A list of the interviews scheduled to take place within a given year. */
	public List<Interview> getInterviewsByDate(int year) {
		return interviewRepository.findAllByDate(year);
	}
	
	/** Returns a list of the interviews scheduled to take place within a given month.
	 * @param year An integer representing the Gregorian year when the interview is scheduled to take place.
	 All digits of the year must be included, e.g. the year 1999 must be entered as "1999" not "99". 
	 * @param month An integer ranging from 1 to 12 representing the month of the year when the interview
	 is scheduled to take place. 
	 * @return A list of the interviews scheduled to take place within a given month. */
	public List<Interview> getInterviewsByDate(int year, int month) {
		return interviewRepository.findAllByDate(year, month);
	}
	
	/** Returns a list of the interviews scheduled to take place on a given day. 
	 * @param year An integer representing the Gregorian year when the interview is scheduled to take place.
	 All digits of the year must be included, e.g. the year 1999 must be entered as "1999" not "99". 
	 * @param month An integer ranging from 1 to 12 representing the month of the year when the interview
	 is scheduled to take place.
	 * @param day The day of the month when the interview is scheduled to take place. 
	 * @return A list of the interviews scheduled to take place on a given day. */
	public List<Interview> getInterviewsByDate(int year, int month, int day) {
		return interviewRepository.findAllByDate(year, month, day);
	}
}

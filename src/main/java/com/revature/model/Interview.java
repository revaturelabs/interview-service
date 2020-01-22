package com.revature.model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * An object representation of our Interview model.
 * 
 * @author Davin Merry
 * @author John Thaddeus Kelly
 */
@Entity
@Table(name = "interviews")
public class Interview {
	
	@Id
	@Column(name = "interview_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** An integer that uniquely identifies this interview. */
	private int id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "interview_profile")
	/** The candidate being interviewed. */
	private Profile profile;

	@Column(name = "interview_date")
	/** The date and time that this interview takes place. */
	private Calendar date;

	@Column(name = "interview_is_complete")
	/** Returns true if the interview has ended, and false if it is in the future or still ongoing. */
	private boolean isComplete;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinColumn(name = "interview_job")
	/** The job that the candidate is applying to. */
	private Job job;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "interviewer_users", joinColumns = { @JoinColumn(name = "interview_id") }, inverseJoinColumns = {
			@JoinColumn(name = "users_id") })
	
	/** The set of employees responsible for conducting this interview. */
	private Set<User> users = new HashSet<>();

	/** Creates a new interview with all properties set to their default values. */
	public Interview() {

	}
	
	/** Creates an interview with its properties set to the values provided. 
	 * @param id An integer that uniquely identifies this interview. 
	 * @param profile The candidate being interviewed.
	 * @param date The date and time that this interview takes place.
	 * @param isComplete Returns true if the interview has ended, and false if it is in the future or still ongoing.
	 * @param job The job that the candidate is applying to. 
	 * @param users The set of employees responsible for conducting this interview. */
	public Interview(int id, Profile profile, Calendar date, boolean isComplete, Job job, Set<User> users) {
		this.id = id;
		this.profile = profile;
		this.date = date;
		this.isComplete = isComplete;
		this.job = job;
		this.users = users;
	}

	/** Returns an integer that uniquely identifies this interview. */
	public int getId() {
		return this.id;
	}

	/** Sets the integer that uniquely identifies this interview. */
	public void setId(int id) {
		this.id = id;
	}

	/** Returns the candidate being interviewed. */
	public Profile getProfile() {
		return this.profile;
	}

	/** Sets the candidate being interviewed. */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/** Returns the date and time that this interview takes place. */
	public Calendar getDate() {
		return this.date;
	}

	/** Sets the date and time that this interview takes place. */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/** Returns true if the interview has ended, and false if it is in the future or still ongoing. */
	public boolean isIsComplete() {
		return this.isComplete;
	}

	/** Returns true if the interview has ended, and false if it is in the future or still ongoing. */
	public boolean getIsComplete() {
		return this.isComplete;
	}

	/** Sets the property that marks whether the interview has ended (true) or is in the future 
	 or still ongoing (false). */
	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	/** Returns the job that the candidate is applying to. */
	public Job getJob() {
		return this.job;
	}

	/** Sets the job that the candidate is applying to. */
	public void setJob(Job job) {
		this.job = job;
	}

	/** Returns the set of employees responsible for conducting this interview. */
	public Set<User> getUsers() {
		return this.users;
	}

	/** Updates the set of employees responsible for conducting this interview. */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	/** Returns a string representation of this interview. */
	public String toString() {
		return "{" + " id='" + getId() + "'" + ", profile='" + getProfile() + "'" + ", date='" + getDate() + "'"
				+ ", isComplete='" + isIsComplete() + "'" + ", job='" + getJob() + "'" + ", users='" + getUsers() + "'"
				+ "}";
	}

}

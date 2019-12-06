package com.revature.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * An object representation of our Interview model.
 * 
 * @author Davin Merry
 * @author John Thaddeus Kelly
 */
@Entity
@Table(name="interviews")
public class Interview {
	@Id
	@Column(name="interview_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="interview_profile")
	@JsonIgnore
	private Profile profile;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name="interview_comments")
	private List<Comment> comments = new ArrayList<>();
	
	@Column(name="interview_date")
	private Timestamp date;
	
	@Column(name="interview_is_complete")
	private boolean isComplete;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="interview_job")
	private Job job;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "interviewer_users", joinColumns = { @JoinColumn(name = "interview_id") }, inverseJoinColumns = {
			@JoinColumn(name = "users_id") })
//	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private Set<User> users = new HashSet<>();
	
	public Interview() {
		super();
	}

	public Interview(int id, Profile profile, List<Comment> comments, Timestamp date, boolean isComplete, Job job,
			Set<User> interviewUsers) {
		super();
		this.id = id;
		this.profile = profile;
		this.comments = comments;
		this.date = date;
		this.isComplete = isComplete;
		this.job = job;
		this.users = interviewUsers;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
//		result = prime * result + ((date == null) ? 0 : date.hashCode());
//		result = prime * result + id;
//		result = prime * result + ((users == null) ? 0 : users.hashCode());
//		result = prime * result + (isComplete ? 1231 : 1237);
//		result = prime * result + ((job == null) ? 0 : job.hashCode());
//		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Interview other = (Interview) obj;
//		if (comments == null) {
//			if (other.comments != null)
//				return false;
//		} else if (!comments.equals(other.comments))
//			return false;
//		if (date == null) {
//			if (other.date != null)
//				return false;
//		} else if (!date.equals(other.date))
//			return false;
//		if (id != other.id)
//			return false;
//		if (users == null) {
//			if (other.users != null)
//				return false;
//		} else if (!users.equals(other.users))
//			return false;
//		if (isComplete != other.isComplete)
//			return false;
//		if (job == null) {
//			if (other.job != null)
//				return false;
//		} else if (!job.equals(other.job))
//			return false;
//		if (profile == null) {
//			if (other.profile != null)
//				return false;
//		} else if (!profile.equals(other.profile))
//			return false;
//		return true;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Set<User> getInterviewUsers() {
		return users;
	}

	public void setInterviewUsers(Set<User> interviewUsers) {
		this.users = interviewUsers;
	}

	@Override
	public String toString() {
		return "Interview [id=" + id + ", profile=" + profile + ", comments=" + comments + ", date=" + date
				+ ", isComplete=" + isComplete + ", job=" + job + ", users=" + users + "]";
	}
	
	
}

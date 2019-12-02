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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
	private Profile profile;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name="interview_comments")
	private List<Comment> comments = new ArrayList<>();
	
	@Column(name="interview_date")
	private Timestamp date;
	
	@Column(name="interview_is_complete")
	private boolean isComplete;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="interview_job")
	private Job job;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name="interview_user")
	private Set<User> users = new HashSet<>();
	
	public Interview() {
		super();
	}
	
	public Interview(int id, Profile profile, List<Comment> comments, Timestamp date, boolean isComplete, Job job,
			Set<User> users) {
		super();
		this.id = id;
		this.profile = profile;
		this.comments = comments;
		this.date = date;
		this.isComplete = isComplete;
		this.job = job;
		this.users = users;
	}

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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Interview [id=" + id + ", profile=" + profile + ", comments=" + comments + ", date=" + date
				+ ", isComplete=" + isComplete + ", job=" + job + ", users=" + users + "]";
	}
}

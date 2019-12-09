package com.revature.model;

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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * An object representation of our User model.
 * This model is considered our "Interviewer".
 * 
 * @author John Thaddeus Kelly
 */
@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	private String username;
	
	@Column
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER,
			cascade= {
					CascadeType.ALL},
	mappedBy= "users")
	@JsonIgnore
	private Set<Interview> interviews = new HashSet<>();
	
	public User() {
		super();
	}

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.interviews = new HashSet<Interview>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Interview> getUserInterviews() {
		return interviews;
	}

	public void setUserInterviews(Set<Interview> userInterviews) {
		this.interviews = userInterviews;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", userInterviews="
				+ interviews + "]";
	}

		
}

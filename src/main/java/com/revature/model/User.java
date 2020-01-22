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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * An object representation of our User model. This model is considered our
 * "Interviewer".
 * 
 * @author John Thaddeus Kelly
 */
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** An integer that uniquely identifies this interviewer. */
	private int id;

	@Column()
	/** The interviewer's username. */
	private String username;

	@Column
	/** The interviewer's password. */
	private String password;
	
	@Column(name = "firstName")
	/** The interviewer's first name. */
	private String firstName;
	
	@Column(name = "lastName")
	/** The interviewer's last name. */
	private String lastName; 

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "users")
	@JsonIgnore
	/** The set of interviews that this user has conducted or is scheduled to conduct. */
	private Set<Interview> interviews = new HashSet<>();

	/** Registers a new interviewer with all properties set to their default values. */
	public User() {
		super();
	}

	/** Registers a new interviewer and initializes their properties to the values provided.
	 * @param id An integer that uniquely identifies this interviewer.
	 * @param username The interviewer's username.
	 * @param password The interviewer's password.
	 * @param firstName The interviewer's first name.
	 * @param lastName The interviewer's last name.
	 * @param interviews The set of interviews that this user has conducted or is scheduled to conduct. */
	public User(int id, String username, String password, String firstName, String lastName, Set<Interview> interviews) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.interviews = interviews;
	}

	/** Returns the integer that uniquely identifies this interviewer.
	 * @return The integer that uniquely identifies this interviewer. */
	public int getId() {
		return id;
	}

	/** Updates the integer that uniquely identifies this interviewer.
	 * @param id The new value of the integer that uniquely identifies this interviewer. */
	public void setId(int id) {
		this.id = id;
	}

	/** Returns the interviewer's username.
	 * @return The interviewer's username. */
	public String getUsername() {
		return username;
	}

	/** Updates the interviewer's username.
	 * @param username The new username. */
	public void setUsername(String username) {
		this.username = username;
	}

	/** Returns the interviewer's password.
	 * @return The interviewer's password. */
	public String getPassword() {
		return password;
	}

	/** Updates the interviewer's password.
	 * @param password The new password. */
	public void setPassword(String password) {
		this.password = password;
	}

	/** Returns the interviewer's first name.
	 * @return The interviewer's first name. */
	public String getFirstName() {
		return firstName;
	}

	/** Updates the interviewer's first name.
	 * @param firstName The interviewer's first name. */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** Returns the interviewer's last name.
	 * @return The interviewer's last name. */
	public String getLastName() {
		return lastName;
	}

	/** Updates the interviewer's last name.
	 * @param lastName The interviewer's last name. */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** Returns the set of interviews that this user has conducted or is scheduled to conduct. 
	 * @return The set of interviews that this user has conducted or is scheduled to conduct. */
	public Set<Interview> getInterviews() {
		return interviews;
	}

	/** Updates the set of interviews that this user has conducted or is scheduled to conduct. 
	 * @param Interviews The set of interviews that this user has conducted or is scheduled to conduct. */
	public void setInterviews(Set<Interview> Interviews) {
		this.interviews = Interviews;
	}

	@Override
	/** Returns a text representation of the interviewer. 
	 * @return A text representation of the interviewer. */
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", interviews=" + interviews + "]";
	}

}

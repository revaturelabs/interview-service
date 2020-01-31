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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * An object representation of our Profile model. This model is considered our
 * "Interviewee".
 * 
 * @author Davin Merry
 * @author John Thaddeus Kelly
 */
@Entity
@Table(name = "profiles")

public class Profile {
	@Id
	@Column(name = "profile_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	/** An integer that uniquely identifies this candidate. */
	private int id;
	@Column(name = "profile_firstName")
	/** The candidate's first name. */
	private String firstName;
	@Column(name = "profile_lastName")
	/** The candidate's last name. */
	private String lastName;
	@Column(name = "profile_location")
	/** The location provided by the candidate. */
	private String location;
	@Column(name = "profile_email_address")
	/** The email address provided by the candidate. */
	private String emailAddress;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "profile_skills", joinColumns = { @JoinColumn(name = "profile_id") }, inverseJoinColumns = {
			@JoinColumn(name = "skill_id") })
	/** A set of skills that the candidate claims proficiency in. */
	private Set<Skill> skills = new HashSet<>();
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "profile")
	@JsonIgnore
	/** A set of interviews that this candidate has been scheduled for. */
	private Set<Interview> interviews;
	@Column(name = "profile_description")
	/** A description of the candidate. */
	private String description;
	/** Creates a new candidate with all properties set to their default values. */
	public Profile() {
		super();
	}
	/** Creates a job with its properties set to the values provided. 
	 * @param id An integer that uniquely identifies this candidate.
	 * @param firstName The candidate's first name.
	 * @param lastName The candidate's last name.
	 * @param location The location provided by the candidate.
	 * @param emailAddress The email address provided by the candidate.
	 * @param description A description of the candidate. */
	public Profile(int id, String firstName, String lastName, String location, String emailAddress, String description) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.emailAddress = emailAddress;
		this.skills = new HashSet<Skill>();
		this.interviews = new HashSet<Interview>();
		this.description = description;
	}
	/** Returns an integer that uniquely identifies this candidate.
	 * @return An integer that uniquely identifies this candidate. */
	public int getId() {
		return id;
	}
	/** Sets the integer that uniquely identifies this candidate.
	 * @param id The new value of the integer that uniquely identifies this candidate. */
	public void setId(int id) {
		this.id = id;
	}
	/** Returns the candidate's first name.
	 * @return The candidate's first name. */
	public String getFirstName() {
		return firstName;
	}
	/** Updates the candidate's first name.
	 * @param firstName The candidate's first name. */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/** Returns the candidate's last name.
	 * @return The candidate's last name. */
	public String getLastName() {
		return lastName;
	}
	/** Updates the candidate's last name.
	 * @param lastName The candidate's last name. */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/** Returns the set of skills that the candidate claims proficiency in.
	 * @return The set of skills that the candidate claims proficiency in. */
	public Set<Skill> getSkills() {
		return skills;
	}
	/** Updates the set of skills that the candidate claims proficiency in.
	 * @param skills The set of skills that the candidate claims proficiency in. */
	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
	/** Returns the set of interviews that this candidate has been scheduled for. 
	 * @return The set of interviews that this candidate has been scheduled for. */
	public Set<Interview> getInterviews() {
		return interviews;
	}
	/** Updates the set of interviews that this candidate has been scheduled for. 
	 * @param interviews The set of interviews that this candidate has been scheduled for. */
	public void setInterviews(Set<Interview> interviews) {
		this.interviews = interviews;
	}
	/** Returns a description of the candidate. 
	 * @return A description of the candidate. */
	public String getDescription() {
		return description;
	}
	/** Updates the description of the candidate. 
	 * @param description A description of the candidate. */
	public void setDescription(String description) {
		this.description = description;
	}
	/** Returns the location provided by the candidate. 
	 * @return The location provided by the candidate. */
	public String getLocation() {
		return location;
	}
	/** Updates the location provided by the candidate.
	 * @param location The location provided by the candidate. */
	public void setLocation(String location) {
		this.location = location;
	}
	/** Returns the email address provided by the candidate. 
	 * @return The email address provided by the candidate. */
	public String getEmailAddress() {
		return emailAddress;
	}
	/** Updates the email address provided by the candidate. 
	 * @param emailAddress The email address provided by the candidate. */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Override
	/** Returns a string representation of the candidate. 
	 * @return A string representation of the candidate. */
	public String toString() {
		return "Profile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", location=" + location
				+ ", emailAddress=" + emailAddress + ", skills=" + skills + ", interviews=" + interviews
				+ ", description=" + description + "]";
	}
}
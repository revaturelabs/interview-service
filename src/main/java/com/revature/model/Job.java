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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * An object representation of our Job model.
 * 
 * @author Davin Merry
 * @author John Thaddeus Kelly
 */
@Entity
@Table(name = "jobs")
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id")
public class Job {
	@Id
	@Column(name = "job_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** An integer that uniquely identifies this job. */
	private int id;
	@Column(name = "job_title")
	/** The name of this job. */
	private String title;
	@Column(name = "job_description", length=10_000)
	/** A description of this job, with a maximum length of 10,000 characters. */
	private String description;
	@Column(name = "job_location")
	/** A string identifying where the job takes place. */
	private String location;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "job_skills", joinColumns = { @JoinColumn(name = "job_id") }, inverseJoinColumns = {
			@JoinColumn(name = "skill_id") })
	/** A set of skills that candidates applying to this job are expected to have. */
	private Set<Skill> skills = new HashSet<>();
	@Column(name = "job_isFilled")
	/** Returns true if the job opening is currently filled, and false otherwise. */
	private boolean isFilled;
	@OneToMany(mappedBy="job")
	private Set<Interview> interviews = new HashSet<>();
	@OneToOne
	@JoinColumn(name = "filled_by_profile_id")
	/** The employee that currently holds this job. Returns null if it is not held by any employee. */
	private Profile profile;
	/** Creates a new job with all properties set to their default values. */
	public Job() {
		super();
	}
	/** Creates a job with its properties set to the values provided. 
	 * @param id An integer that uniquely identifies this job.
	 * @param title The name of this job.
	 * @param description A description of this job, with a maximum length of 10,000 characters.
	 * @param location A string identifying where the job takes place.
	 * @param skills A set of skills that candidates applying to this job are expected to have. 
	 * @param isFilled Marks whether the job opening is currently filled (true) or unfilled (false). */
	public Job(int id, String title, String description, String location, Set<Skill> skills, boolean isFilled) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		this.skills = skills;
		this.isFilled = isFilled;
	}
	/** Returns an integer that uniquely identifies this job.
	 * @return The integer that uniquely identifies this job. */
	public int getId() {
		return id;
	}
	/** Sets the integer that uniquely identifies this job.
	 * @param The new value of the integer that uniquely identifies this job. */
	public void setId(int id) {
		this.id = id;
	}
	/** Returns the name of this job. 
	 * @param The name of this job. */
	public String getTitle() {
		return title;
	}
	/** Sets the name of this job. 
	 * @param title The new name of this job. */
	public void setTitle(String title) {
		this.title = title;
	}
	/** Returns a description of this job. 
	 * @return A string describing this job.*/
	public String getDescription() {
		return description;
	}
	/** Sets the description of this job. Maximum length is 10,000 characters.
	 * @param description The new description for this job. Maximum length is 10,000 characters. */
	public void setDescription(String description) {
		this.description = description;
	}
	/** Returns the set of skills that candidates applying to this job are expected to have. 
	 * @return The set of skills that candidates applying to this job are expected to have. */
	public Set<Skill> getSkills() {
		return skills;
	}
	/** Updates the set of skills that candidates applying to this job are expected to have.
	 * @param skills The new the set of skills that candidates applying to this job are expected to have. */
	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}
	/** Returns true if the job opening is currently filled, and false otherwise. 
	 * @return True if the job opening is currently filled, and false otherwise. */
	public boolean isFilled() {
		return isFilled;
	}
	/** Updates the boolean flag that marks whether the job opening is currently filled (true) or unfilled (false). 
	 * @param isFilled The new boolean value that marks whether the job opening is currently filled (true)
	  or unfilled (false).*/
	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
	/** Returns a string identifying where the job takes place. 
	 * @return A string identifying where the job takes place. */
	public String getLocation() {
		return location;
	}
	/** Updates the string that identifies where the job takes place.
	 * @param location A string that identifies where the job takes place. */
	public void setLocation(String location) {
		this.location = location;
	}
	/** Returns the employee that currently holds this job. Returns null if it is not held by any employee. 
	 * @return The employee that currently holds this job. Returns null if it is not held by any employee. */
	public Profile getProfile() {
		return profile;
	}
	/** Sets the employee that currently holds this job. A value of null indicates that the job is unfilled.
	 * @param profile The employee that currently holds this job. A value of null indicates that the job is unfilled. */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	@Override
	/** A string representation of this job.
	 * @return A string representation of this job. */
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", skills=" + skills + ", isFilled=" + isFilled + ", interviews=" + interviews + ", profile="
				+ profile + "]";
	}
}
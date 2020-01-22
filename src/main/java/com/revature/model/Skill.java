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
 * An object representation of our Skill model.
 * 
 * @author Davin Merry
 */
@Entity
@Table(name = "skills")
public class Skill {

	@Id
	@Column(name = "skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** An integer that uniquely identifies this skill. */
	private int id;

	@Column(name = "skill_title")
	/** The name of this skill. */
	private String title;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE }, mappedBy = "skills")
	@Column(name = "profiles")
	@JsonIgnore
	/** A set of candidates who claim proficiency in this skill. */
	private Set<Profile> profiles = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE }, mappedBy = "skills")
	@Column(name = "jobs")
	@JsonIgnore
	/** A set of jobs that this skill is necessary for. */
	private Set<Job> jobs = new HashSet<>();

	/** Creates a new skill with all properties set to their default values. */
	public Skill() {
		super();
	}

	@Override
	/** Returns a text representation of this skill. 
	 * @return A text representation of this skill. */
	public String toString() {
		return "Skill [id=" + id + ", title=" + title + ", profiles=" + profiles.toArray() + "]";
	}

	/** Creates a new skill with its properties set to the values provided. 
	 * @param id An integer that uniquely identifies this skill.
	 * @param title The name of this skill. 
	 * @param skillProfiles A set of candidates that claim proficiency in this skill. */
	public Skill(int id, String title, Set<Profile> skillProfiles) {
		super();
		this.id = id;
		this.title = title;
		this.profiles = skillProfiles;
	}

	/** Returns the integer that uniquely identifies this skill. 
	 * @return The integer that uniquely identifies this skill. */
	public int getId() {
		return id;
	}

	/** Updates the integer that uniquely identifies this skill. 
	 * @param id The new value of the integer that uniquely identifies this skill. */
	public void setId(int id) {
		this.id = id;
	}

	/** Returns the name of this skill.
	 * @return The name of this skill. */
	public String getTitle() {
		return title;
	}

	/** Updates the name of this skill.
	 * @param title The new name of this skill. */
	public void setTitle(String title) {
		this.title = title;
	}

	/** Returns a set of candidates who claim proficiency in this skill.
	 * @return The set of candidates who claim proficiency in this skill. */
	public Set<Profile> getProfiles() {
		return profiles;
	}

	/** Updates the set of candidates who claim proficiency in this skill.
	 * @param profiles The set of candidates who claim proficiency in this skill. */
	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}

	/** Returns a set of jobs that this skill is necessary for.
	 * @return The set of jobs that this skill is necessary for. */
	public Set<Job> getJobs() {
		return jobs;
	}

	/** Updates the set of jobs that this skill is necessary for.
	 * @param jobs The set of jobs that this skill is necessary for. */
	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

}

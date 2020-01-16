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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * An object representation of our Job model.
 * 
 * @author Davin Merry
 * @author John Thaddeus Kelly
 */
@Entity
@Table(name = "jobs")
public class Job {
	@Id
	@Column(name = "job_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "job_title")
	private String title;

	@Column(name = "job_description", length=10_000)
	private String description;
	
	@Column(name = "job_location")
	private String location;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "job_skills", joinColumns = { @JoinColumn(name = "job_id") }, inverseJoinColumns = {
			@JoinColumn(name = "skill_id") })
	private Set<Skill> skills = new HashSet<>();

	@Column(name = "job_isFilled")
	private boolean isFilled;
	
	@OneToOne
	@JoinColumn(name = "filled_by_profile_id")
	private Profile profile;

	public Job() {
		super();
	}

	public Job(int id, String title, String description, String location, Set<Skill> skills, boolean isFilled) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		this.skills = skills;
		this.isFilled = isFilled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", skills=" + skills + ", isFilled=" + isFilled + ", profile=" + profile + "]";
	}
}

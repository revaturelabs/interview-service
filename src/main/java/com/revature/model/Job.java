package com.revature.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * An object representation of our Job model.
 * 
 * @author Davin Merry
 * @author John Thaddeus Kelly
 */
@Entity
@Table(name="jobs")
public class Job {
	@Id
	@Column(name="job_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="job_title")
	private String title;
	
	@Column(name="job_description")
	private String description;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="job_skills",
				joinColumns = {@JoinColumn(name = "job_id")},
				inverseJoinColumns = {@JoinColumn(name = "skill_id")})
	private List<Skill> skills = new ArrayList<>();
	
	@Column(name="job_isFilled")
	private boolean isFilled;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name="job_profiles")
	private List<Profile> profiles = new ArrayList<>();
	
	public Job() {
		super();
	}
	
	public Job(int id, String title, String description, List<Skill> skills, boolean isFilled, List<Profile> profiles) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.skills = skills;
		this.isFilled = isFilled;
		this.profiles = profiles;
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

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", skills=" + skills
				+ ", isFilled=" + isFilled + ", profiles=" + profiles + "]";
	}
}

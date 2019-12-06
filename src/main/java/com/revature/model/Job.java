package com.revature.model;

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
	
	@ManyToMany(fetch = FetchType.EAGER,
			cascade = CascadeType.ALL)
	@JoinTable(name="job_skills",
				joinColumns = {@JoinColumn(name = "job_id")},
				inverseJoinColumns = {@JoinColumn(name = "skill_id")})
	private Set<Skill> skills = new HashSet<>();
	
	@Column(name="job_isFilled")
	private boolean isFilled;
	
	@ManyToMany(fetch = FetchType.EAGER,
			cascade = CascadeType.ALL)
	@JoinTable(name="job_profiles",
	joinColumns = {@JoinColumn(name = "job_id")},
	inverseJoinColumns = {@JoinColumn(name = "profile_id")})
	private Set<Profile> profiles = new HashSet<>();
	
	public Job() {
		super();
	}
	
	public Job(int id, String title, String description, Set<Skill> skills, boolean isFilled, Set<Profile> profiles) {
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

	public Set<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + (isFilled ? 1231 : 1237);
		result = prime * result + ((profiles == null) ? 0 : profiles.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		}
		else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (isFilled != other.isFilled)
			return false;
		if (profiles == null) {
			if (other.profiles != null)
				return false;
		}
		else if (!profiles.equals(other.profiles))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		}
		else if (!skills.equals(other.skills))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		}
		else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", skills=" + skills
				+ ", isFilled=" + isFilled + ", profiles=" + profiles + "]";
	}
}

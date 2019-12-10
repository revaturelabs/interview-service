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
	private int id;

	@Column(name = "skill_title")
	private String title;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "skills")
	@Column(name = "profiles")
	@JsonIgnore
	private Set<Profile> profiles = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, mappedBy = "skills")
	@Column(name = "jobs")
	@JsonIgnore
	private Set<Job> jobs = new HashSet<>();

	public Skill() {
		super();
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", title=" + title + ", profiles=" + profiles + "]";
	}

	public Skill(int id, String title, Set<Profile> skillProfiles) {
		super();
		this.id = id;
		this.title = title;
		this.profiles = skillProfiles;
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

	public Set<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}

	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + id;
	// result = prime * result + ((profiles == null) ? 0 : profiles.hashCode());
	// result = prime * result + ((title == null) ? 0 : title.hashCode());
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// Skill other = (Skill) obj;
	// if (id != other.id)
	// return false;
	// if (profiles == null) {
	// if (other.profiles != null)
	// return false;
	// } else if (!profiles.equals(other.profiles))
	// return false;
	// if (title == null) {
	// if (other.title != null)
	// return false;
	// } else if (!title.equals(other.title))
	// return false;
	// return true;
	// }

}

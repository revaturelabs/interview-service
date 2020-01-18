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

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE }, mappedBy = "skills")
	@Column(name = "profiles")
	@JsonIgnore
	private Set<Profile> profiles = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE }, mappedBy = "skills")
	@Column(name = "jobs")
	@JsonIgnore
	private Set<Job> jobs = new HashSet<>();

	public Skill() {
		super();
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", title=" + title + ", profiles=" + profiles.toArray() + "]";
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

}

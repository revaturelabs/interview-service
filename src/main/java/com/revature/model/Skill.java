package com.revature.model;
import java.util.HashSet;
import java.util.Objects;
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
	/** A set of candidates who claim proficiency in this skill. */
	
	@JsonIgnore
	private Set<Profile> profiles = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE }, mappedBy = "skills")
	@Column(name = "jobs")
	/** A set of jobs that this skill is necessary for. */
	@JsonIgnore
	private Set<Job> jobs = new HashSet<>();
	
	/** Creates a new skill with all properties set to their default values. */
	public Skill() {
		super();
	}
	public Skill(String title, Set<Profile> profiles, Set<Job> jobs) {
		super();
		this.title = title;
		this.profiles = profiles;
		this.jobs = jobs;
	}
	public Skill(int id, String title, Set<Profile> profiles, Set<Job> jobs) {
		super();
		this.id = id;
		this.title = title;
		this.profiles = profiles;
		this.jobs = jobs;
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
	@Override
	public int hashCode() {
		return Objects.hash(id, jobs, profiles, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Skill)) {
			return false;
		}
		Skill other = (Skill) obj;
		return id == other.id && Objects.equals(jobs, other.jobs) && Objects.equals(profiles, other.profiles)
				&& Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Skill [id=" + id + ", title=" + title + ", profiles=" + profiles + ", jobs=" + jobs + "]";
	}
}
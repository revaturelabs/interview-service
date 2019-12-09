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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "profile_firstName")
	private String firstName;

	@Column(name = "profile_lastName")
	private String lastName;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// @LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "profile_skills", joinColumns = { @JoinColumn(name = "profile_id") }, inverseJoinColumns = {
			@JoinColumn(name = "skill_id") })
	private Set<Skill> skills = new HashSet<>();

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "profile")
	// @LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private Set<Interview> interviews;

	@Column(name = "profile_description")
	private String description;

	public Profile() {
		super();
	}

	public Profile(int id, String firstName, String lastName, String description) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.skills = new HashSet<Skill>();
		this.interviews = new HashSet<Interview>();
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Set<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(Set<Interview> interviews) {
		this.interviews = interviews;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// public Set<Job> getJobs() {
	// return jobs;
	// }

	// public void setJobs(Set<Job> jobs) {
	// this.jobs = jobs;
	// }

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + ((description == null) ? 0 :
	// description.hashCode());
	// result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	// result = prime * result + id;
	// result = prime * result + ((interviews == null) ? 0 : interviews.hashCode());
	// result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	// result = prime * result + ((skills == null) ? 0 : skills.hashCode());
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
	// Profile other = (Profile) obj;
	// if (description == null) {
	// if (other.description != null)
	// return false;
	// } else if (!description.equals(other.description))
	// return false;
	// if (firstName == null) {
	// if (other.firstName != null)
	// return false;
	// } else if (!firstName.equals(other.firstName))
	// return false;
	// if (id != other.id)
	// return false;
	// if (interviews == null) {
	// if (other.interviews != null)
	// return false;
	// } else if (!interviews.equals(other.interviews))
	// return false;
	// if (lastName == null) {
	// if (other.lastName != null)
	// return false;
	// } else if (!lastName.equals(other.lastName))
	// return false;
	// if (skills == null) {
	// if (other.skills != null)
	// return false;
	// } else if (!skills.equals(other.skills))
	// return false;
	// return true;
	// }

	@Override
	public String toString() {
		return "Profile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", skills=" + skills
				+ ", interviews=" + interviews + ", description=" + description + "]";
	}
}
